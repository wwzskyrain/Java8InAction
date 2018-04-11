package lambdasinaction.chap2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortDemo {

    public static void main(String[] args) {

        List<FilteringApples.Apple> inventory = Arrays.asList(
                new FilteringApples.Apple(80, "green"),
                new FilteringApples.Apple(155, "green"),
                new FilteringApples.Apple(120, "red"));


        inventory.sort(Comparator.comparing(FilteringApples.Apple::getWeight));

        System.out.println(inventory);

    }

}
