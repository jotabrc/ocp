
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Exercises {

    public static void main(String[] args) {
        q1();
        q2();
        q3();
        q4();

        // Q5
        String grade1 = getGrade(50).orElse("UNKNOWN");
        System.out.println(grade1);
        getGrade(55).ifPresentOrElse(System.out::println, () -> System.out.println("Empty"));
        // =====

        q6();
        q7();
    }

    /**
     * Average of inclusive 0-5 exclusive
     */
    private static void q1() {
        var list = List.of(0, 1, 2, 3, 4);
        OptionalDouble avg = list.stream().mapToInt(Integer::intValue).average();
        avg.ifPresent(System.out::println);

        var avg2 = IntStream.range(0, 5).average();
        avg2.ifPresent(System.out::println);
    }

    /**
     * Sort
     */
    private static void q2() {
        List<Item> list = List.of(
                new Item(1, "Screw"),
                new Item(2, "Nail"),
                new Item(3, "Bolt")
        );

        list
                .stream()
                .sorted(Comparator.comparing(Item::getName))
                .forEach(System.out::print);
        System.out.println();
    }

    /**
     * Flat Stream of List<String> and filter String equal to "c"
     */
    private static void q3() {
        Stream.of(Arrays.asList("a", "b"), Arrays.asList("a", "c"))
                .flatMap(Collection::stream)
                .filter(s -> s.equals("c"))
                .forEach(System.out::println);

    }

    /**
     * sum, max and reduce with IntStream
     */
    private static void q4() {
        int sum = IntStream.range(0, 5)
                .sum();
        System.out.println("sum: " + sum);

        int max = IntStream.range(0, 5)
                .sum();
        System.out.println("max: " + max);

        List<Person> personList = List.of(
                new Person("Alan", "Burke", 22),
                new Person("Zoe", "Peters", 20),
                new Person("Peter", "Castle", 29)
        );

        personList.stream()
                .mapToInt(Person::getAge)
                .max()
                .stream()
                .forEach(System.out::println);

        int maxValue = IntStream.of(10, 47, 33, 23)
                .reduce(0, Integer::sum);
        System.out.println("maxValue: " + maxValue);

        IntStream.of(10, 47, 33, 23)
                .reduce(Integer::sum)
                .stream().forEach(System.out::println);
    }

    /**
     * Return Optional of String
     */
    private static Optional<String> getGrade(int marks) {
        return marks > 50 ?
                Optional.of("PASS") : Optional.of("FAIL");
    }

    /**
     * List to DoubleStream
     */
    private static void q6() {
        List<Book> books = List.of(
                new Book("Thinking in Java", 30.0),
                new Book("Java in 24 hrs", 20.0),
                new Book("Java Recipes", 10.0)
        );

        books.stream()
                .mapToDouble(Book::getPrice)
                .filter(d -> d > 10)
                .average()
                .stream()
                .forEach(System.out::println);

        books.stream()
                .mapToDouble(Book::getPrice)
                .filter(d -> d > 90)
                .average()
                .stream()
                .forEach(System.out::println);
    }

    /**
     * List to Map
     * print prices from Books starting with A
     */
    private static void q7() {
        List<Book> books = List.of(
                new Book("Atlas Shrugged", 10.0),
                new Book("Freedom at Midnight", 5.0),
                new Book("Gone with the wind", 5.0)
        );

        books.stream()
                .collect(Collectors.toMap(Book::getTitle, Book::getPrice))
                .entrySet()
                .stream()
                .filter(k -> k.getKey().startsWith("A"))
                .forEach(b -> System.out.println(b.getValue()));
    }
}
