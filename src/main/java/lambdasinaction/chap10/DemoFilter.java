package lambdasinaction.chap10;

import java.util.Optional;

public class DemoFilter {

    //    对应10.3.6
    public static boolean checkName(Optional<DemoFlatMap.Insurance1> optionalInsurance1) {

        boolean result = false;

        Optional<DemoFlatMap.Insurance1> insurance = optionalInsurance1.filter(insurance1 -> "CambrigeInsurance".equals(insurance1.getName()));

        return insurance.isPresent();

    }


    //  对应检测10.2:
    public String getCarInsuranceName(Optional<Person> person, int minAge) {

        return person.filter(per -> per.getAge() >= minAge)
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("unknown");
    }

}
