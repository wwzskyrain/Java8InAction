package lambdasinaction.chap6;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author erik.wang  @date 2019/02/16
 **/
public class ErikDemoGrouping {

    public static void groupingAndCount(){

        Map<Integer, Long> counter = IntStream.range(0, 100).boxed().collect(Collectors.groupingBy(i->i%6, Collectors.counting()));
        System.out.println(counter);

    }

    public static void main(String[] args) {
        groupingAndCount();
    }

}
