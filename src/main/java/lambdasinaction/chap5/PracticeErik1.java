package lambdasinaction.chap5;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PracticeErik1 {

    public static void main(String[] args) {

        Stream<double[]> pythagoreanTriples = getPythagoreanTriples();

        pythagoreanTriples.limit(10).forEach(a-> System.out.println(Arrays.toString(a)));

    }

    public static Stream<double[]> getPythagoreanTriples() {
        return IntStream.rangeClosed(1, 1000).boxed().flatMap(
                a -> IntStream.rangeClosed(a, 100)
                        .mapToObj(b -> new double[]{a, b, Math.sqrt(a * a + b * b)})
                        .filter(t -> t[2] % 1 == 0));

    }

}
