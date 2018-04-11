package lambdasinaction.chap4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapDemo {

    public static void main(String[] args) {


        demo2();

    }


    static void demo1() {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);

        List<Integer> numbers2 = Arrays.asList(3, 4);

        List<int[]> pairs = numbers1.stream()
                .flatMap(i -> numbers2.stream()
                        .map(j -> new int[]{i, j}))
                .collect(Collectors.toList());

        pairs.forEach(pair -> System.out.println(Arrays.toString(pair)));
    }

    static void demo2() {

        String[] arrayOfWords = {"Hello", "World"};
        Stream<String> streamOfWords = Arrays.stream(arrayOfWords);
        streamOfWords.forEach(System.out::println);

        List<String> words = Arrays.asList("Java 8", "Lambadas", "In", "action");

        List<String[]> list1 = words.stream().map(word -> word.split("")).collect(Collectors.toList());

        list1.forEach(word -> System.out.println(Arrays.toString(word)));

        List<Stream<String>> list2 = words.stream().map(word -> word.split("")).map(Arrays::stream).distinct().collect(Collectors.toList());

        list2.forEach(stream ->
        {
            stream.forEach(System.out::print);
            System.out.println();
        });

        List<String> charList = words.stream().map(word -> word.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());

        charList.forEach(System.out::println);


    }

}
