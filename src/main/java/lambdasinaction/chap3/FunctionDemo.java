package lambdasinaction.chap3;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class FunctionDemo {


    public static void main(String[] args) {

        List<String> stringList = Arrays.asList("aaa", "bbb", "ccc", "ddd");

        new FunctionDemo().foreach(stringList, String::length);   //non-static method cannot be referenced from a static context.

//        new FunctionDemo().foreach1(stringList,String::getBytes);
    }

    public <T> void foreach(List<T> list, Consumer<T> consumer) {
        for (T t : list) {
            consumer.accept(t);
            System.out.println(t);
        }
    }

    public <T, R> void foreach1(List<T> list, Function<T, R> function) {
        for (T t : list) {
            R result = function.apply(t);
            System.out.println(result);
        }
    }

}
