package lambdasinaction.chap10;

import java.util.Optional;

public class DemoFlatMap {

    class Person1 {

    }

    class Car1 {

    }

    class Insurance1 {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static Insurance1 findCheapestInsurance(Person1 person, Car1 car) {

        DemoFlatMap demoFlatMap = new DemoFlatMap();
        return demoFlatMap.new Insurance1();
    }


    public static Optional<Insurance1> nullSafeFindCheapestInsurance(Optional<Person1> person, Optional<Car1> car) {

        return person.flatMap(p -> car.map(c -> findCheapestInsurance(p, c)));

    }


    public static boolean checkName(Optional<Insurance1> optionalInsurance1){

        boolean result=false;

        Optional<Insurance1> insurance = optionalInsurance1.filter(insurance1 -> "CambrigeInsurance".equals(insurance1.getName()));

        return insurance.isPresent();

    }

}
