package org.kodejava.example.generics;

import java.util.ArrayList;
import java.util.List;

public class ForEachGeneric {

    public void loopWithoutGeneric() {
        List customers = new ArrayList();
        customers.add(new Customer());
        customers.add(new Customer());
        customers.add(new Customer());

        for (int i = 0; i < customers.size(); i++) {
            Customer customer = (Customer) customers.get(i);
            System.out.println(customer.getFirstName());
        }
    }

    public void loopWithGeneric() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer());
        customers.add(new Customer());
        customers.add(new Customer());

        for (Customer customer : customers) {
            System.out.println(customer.getFirstName());
        }
    }
}
