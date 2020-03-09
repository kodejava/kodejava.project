package org.kodejava.example.stream;

public class TestPerson {
    public static void main(String[] args) {
        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.build("Wayan", "Saryada");
        System.out.println("personFactory = " + personFactory);

        PersonFactory<Person> personFactory1 = new PersonFactory<Person>() {
            @Override
            public Person build(String firstName, String lastName) {
                return new Person(firstName, lastName);
            }
        };
    }
}
