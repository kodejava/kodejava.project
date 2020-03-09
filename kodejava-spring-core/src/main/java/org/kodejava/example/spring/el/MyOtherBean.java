package org.kodejava.example.spring.el;

public class MyOtherBean {
    public static final String BEAN_NAME = "MyOtherBean";

    private String randomNumber;
    private String pi;
    private String name;

    public void setRandomNumber(String randomNumber) {
        this.randomNumber = randomNumber;
    }

    public String getRandomNumber() {
        return randomNumber;
    }

    public void setPi(String pi) {
        this.pi = pi;
    }

    public String getPi() {
        return pi;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
