package lambdasinaction.chap10;

import java.io.Serializable;
import java.util.Optional;

public class PersonImplSerializable implements Serializable{
    private static final long serialVersionUID = -8964759093461160941L;

    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Optional<Car> getCarAsOptional(){
        return Optional.ofNullable(car);
    }
}
