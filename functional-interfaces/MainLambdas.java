import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MainLambdas {

    public static void main(String[] args) {
        consumer();
        System.out.println("=".repeat(30));

        supplier();
        System.out.println("=".repeat(30));

        predicate();
        System.out.println("=".repeat(30));

        function();
        System.out.println("=".repeat(30));

        var listPeople = getPeople();

        sortAge(listPeople);
        System.out.println("=".repeat(30));

        sortName(listPeople);
        System.out.println("=".repeat(30));

        sortHeight(listPeople);
        System.out.println("=".repeat(30));
    }

    public static void consumer() {
        Printable<String> printable = (s) -> System.out.println(s);
        Printable<String> printable1 = System.out::println;
        printable.print("Lambda");
        printable1.print("Method Reference");
    }

    public static void supplier() {
        Supplier<Integer> supplier = () -> 77;
        Retrievable<Integer> supplier1 = () -> new Random().nextInt();
        System.out.println(supplier.get());
        System.out.println();
        System.out.println(supplier1.retrieve());
    }

    public static void predicate() {
        Predicate<Integer> evaluate = (i) -> i < 0;
        Evaluate<Integer> evaluate1 = (i) -> i < 0;
        System.out.println(evaluate.test(1));
        System.out.println();
        System.out.println(evaluate1.isNegative(-1));
    }

    public static void function() {
        Function<Integer, String> function = (i) -> "Nubmer is: " + i;
        Functionable<Integer, String> functionable = (i) -> "Number is: " + i;
        System.out.println(function.apply(50));
        System.out.println();
        System.out.println(functionable.applyThis(50));
    }

    private static List<Person> getPeople() {
        List<Person> result = new ArrayList<>();
        result.add(new Person("Mike", 33, 1.8));
        result.add(new Person("Mary", 25, 1.4));
        result.add(new Person("Alan", 34, 1.7));
        result.add(new Person("Zoe", 30, 1.5));
        return result;
    }

    private static void sortAge(List<Person> list) {
        Comparator<Person> comparator = (p, p2) -> p.getAge().compareTo(p2.getAge());
        Comparator<Person> comparator1 = Comparator.comparing(Person::getAge);
        list.sort(comparator);
        list.forEach(System.out::println);
        System.out.println();
        list.sort(comparator1);
        list.forEach(System.out::println);
    }

    private static void sortName(List<Person> list) {
        Comparator<Person> comparator = (p, p1) -> p.getName().compareTo(p1.getName());
        Comparator<Person> comparator1 = Comparator.comparing(Person::getName);
        list.sort(comparator1);
        list.forEach(System.out::println);
        System.out.println();
        list.sort(comparator);
        list.forEach(System.out::println);
    }

    private static void sortHeight(List<Person> list) {
        Comparator<Person> comparator = (p, p1) -> p.getHeight().compareTo(p1.getHeight());
        Comparator<Person> comparator1 = Comparator.comparing(Person::getHeight);
        list.sort(comparator1);
        list.forEach(System.out::println);
        System.out.println();
        list.sort(comparator);
        list.forEach(System.out::println);
    }
}
