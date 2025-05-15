package j8.ocp.java_stream_api;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class Exercises {

    public static void main(String[] args) {
        q1();
    }
    private static void q1() {
        var list = List.of(0, 1, 2, 3, 4);
        OptionalDouble avg = list.stream().mapToInt(Integer::intValue).average();
        avg.ifPresent(System.out::println);

        var avg2 = IntStream.range(0, 5).average();
        avg2.ifPresent(System.out::println);
    }
}
