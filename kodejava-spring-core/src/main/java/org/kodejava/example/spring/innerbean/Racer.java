package org.kodejava.example.spring.innerbean;

public class Racer {
    private Car car;

    public Racer() {
    }

    public Racer(Car car) {
        this.car = car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Racer{" +
            "car=" + car +
            '}';
    }
}
