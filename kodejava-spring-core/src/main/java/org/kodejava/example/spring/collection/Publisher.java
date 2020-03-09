package org.kodejava.example.spring.collection;

public class Publisher {
    private String name;

    public Publisher() {
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "name=" + name +
                '}';
    }
}
