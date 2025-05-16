
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Exercises {

    public static void main(String[] args) {
//        q1();
//        q2();
//        q3();
//        q4();
//
//        // Q5
//        String grade1 = getGrade(50).orElse("UNKNOWN");
//        System.out.println(grade1);
//        getGrade(55).ifPresentOrElse(System.out::println, () -> System.out.println("Empty"));
//        // =====
//
//        q6();
//        q7();
//        q8();
//        q9();
        q10();
        q11();
        q12();
        q13();
        q14();
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

    /**
     * Map list to Map concatenating duplicated keys
     */
    private static void q8() {
        List<Book> books = List.of(
                new Book("Gone with the wind", 5.0),
                new Book("Gone with the wind", 10.0),
                new Book("Atlas shrugged", 15.0)
        );

        books
                .stream()
                .collect(
                        Collectors.toMap(
                                Book::getTitle,
                                b -> String.valueOf(b.getPrice()),
                                (s1, s2) -> s1 + ", " + s2
                        ))
                .forEach((k, v) -> System.out.println("title=" + k + " price=" + v));
    }

    /**
     * Use of orElse to avoid exceptions on null terminal operations
     */
    private static void q9() {
        List<Person> personList = List.of(
                new Person("Bob", null, 31),
                new Person("Paul", null, 32),
                new Person("John", null, 33)
        );

        double result = personList
                .stream()
                .filter(p -> p.getAge() < 30)
                .mapToInt(Person::getAge)
                .average()
                .orElse(0.0);
        System.out.println(result);
    }

    /**
     * Using Optional to avoid exceptions and get alternative values
     */
    private static void q10() {
        Optional<Double> price = Optional.of(20.0);
        price.ifPresent(System.out::println);

        price = Optional.empty();
        System.out.println(price.orElse(0.0));
        System.out.println(price.orElseGet(() -> new Random().nextDouble()));

        price = Optional.empty();
        System.out.println(price);
        price.ifPresentOrElse(System.out::println, () -> System.out.println("Empty"));
    }

    /**
     * Map new list with book genres
     */
    private static void q11() {
        List<AnotherBook> list = List.of(
                new AnotherBook("Gone with the wind", "Fiction"),
                new AnotherBook("Bourne Ultimatum", "Thriller"),
                new AnotherBook("The Client", "Thriller")
        );

        list
                .stream()
                .map(AnotherBook::getGenre)
                .toList()
                .forEach(System.out::println);
    }

    /**
     * Sum odd numbers
     * Get average of Double wrapper avoiding exceptions
     */
    private static void q12() {
        double sum = DoubleStream.of(0, 2, 4)
                .filter(d -> d % 2 != 0)
                .sum();
        System.out.println(sum); //0.0

        double avg = Stream.of(1.0, 3.0)
                .mapToDouble(Double::doubleValue)
                .filter(d -> d % 2 == 0)
                .average()
                .orElse(0.0);

        System.out.println(avg); //0.0
    }

    private static void q13() {
        List<Integer> ls = Arrays.asList(11, 11, 22, 33, 33, 55, 66);
        boolean result = ls
                .stream()
                .distinct()
                .anyMatch(i -> i == 11);
        System.out.println(result); // true

        result = ls
                .stream()
                .noneMatch(i -> i % 11 > 0);
        System.out.println(result); // true
    }

    private static void q14() {
        AtomicInteger ai = new AtomicInteger();
        Stream.of(11, 11, 22, 33)
                .parallel()
                .filter(n -> {
                    ai.incrementAndGet();
                    return n % 2 == 0;
                });
        // ai is zero because no terminal operation is in use, and streams are lazy by nature;
        // intermediate operations will not run unless a terminal operation is in place.
        System.out.println(ai);

        AtomicInteger ai2 = new AtomicInteger();
        Stream<Integer> stream = Stream.of(11, 11, 22, 33)
                .parallel();

        stream
                .filter(e -> {
                    ai2.incrementAndGet();
                    return e % 2 == 0;
                })
                .forEach(System.out::println);
        System.out.println(ai2);

    }
}
