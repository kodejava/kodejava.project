package org.kodejava.example.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericCollection {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer());
        customers.add(new Customer());

        //customers.add(new Product()); // Compile time error!

        // No cast operator required.
        Customer customer = customers.get(0);

        for (Customer cust : customers) {
            System.out.println(cust);
        }
    }
}
