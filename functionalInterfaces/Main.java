
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {
        staticMR();
        boundMR();
        unboundMR();
        constructorMR();
    }

    private static void staticMR() {
        List<Integer> list = new ArrayList<>();
        list.addAll(List.of(1, 2, 7, 4, 5));
        Consumer<List<Integer>> consumer = Collections::sort;
        consumer.accept(list);
        list.forEach(System.out::println);
    }

    private static void boundMR() {
        String name = "Mr. Joe Bloggs";
        Predicate<String> predicate = name::startsWith;
        System.out.println(name + " starts with Mr.: " + predicate.test("Mr."));
        System.out.println(name + " starts with Ms.: " + predicate.test("Ms."));
    }

    private static void unboundMR() {
        Predicate<String> predicate = String::isEmpty;
        System.out.println("Is Empty: " + predicate.test(""));
        System.out.println("Is Empty: " + predicate.test("xyz"));

        BiPredicate<String, String> biPredicate = String::startsWith;
        System.out.println("Start with Mr.: " + biPredicate.test("Mr. Joe Bloggs", "Mr."));
        System.out.println("Start with Mr.: " + biPredicate.test("Mr. Joe Bloggs", "Ms."));
    }

    private static void constructorMR() {
        Supplier<List<String>> supplier = () -> new ArrayList<String>();
        Supplier<List<String>> supplier1 = ArrayList::new;

        var list = supplier.get();
        list.add("Lambda");
        list.forEach(System.out::println);
        list = supplier1.get();
        list.add("Method Reference");
        list.forEach(System.out::println);

        Function<Integer, List<String>> function = (i) -> new ArrayList<>(i);
        Function<Integer, List<String>> function1 = ArrayList::new;

        list = function.apply(10);
        list.add("Lambda");
        list.forEach(System.out::println);
        list = function1.apply(10);
        list.add("Method Reference");
        list.forEach(System.out::println);
    }
}
