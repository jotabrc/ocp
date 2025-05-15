
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Exercises {

    public static void main(String[] args) {
        q1();
        q2();
        q3();
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
}
