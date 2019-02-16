package lambdasinaction.chap10;

import java.util.*;

public class Person {

    private Optional<Car> car;  //如果一个person没有car，那么给属性car=Optional.EMPTY;

    public Optional<Car> getCar() {
        return car;
    }

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
