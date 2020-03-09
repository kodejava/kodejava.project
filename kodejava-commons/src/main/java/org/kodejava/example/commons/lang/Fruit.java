package org.kodejava.example.commons.lang;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Fruit implements Comparable<Fruit> {
    private String name;
    private String colour;

    public Fruit(String name, String colour) {
        this.name = name;
        this.colour = colour;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fruit fruit = (Fruit) o;

        return new EqualsBuilder()
            .append(name, fruit.name)
            .append(colour, fruit.colour)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
            .append(name)
            .append(colour)
            .toHashCode();
    }

    /*
     * Generating compareTo() method using CompareToBuilder class. For other
     * alternative way we can also use the CompareToBuilder.reflectionCompare()
     * method to implement the compareTo() method.
     */
    public int compareTo(Fruit fruit) {
        return new CompareToBuilder()
            .append(this.name, fruit.name)
            .append(this.colour, fruit.colour)
            .toComparison();
    }
}
