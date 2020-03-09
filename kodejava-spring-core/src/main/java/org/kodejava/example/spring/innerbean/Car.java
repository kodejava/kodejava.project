package org.kodejava.example.spring.innerbean;

public class Car {
    private String maker;
    private int year;

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Car{" +
            "maker='" + maker + "'" +
            ", year=" + year +
            '}';
    }
}
