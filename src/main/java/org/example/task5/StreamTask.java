package org.example.task5;

import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTask {
    public static void main(String[] args){
        //Stream:
        //a) Generate 10 random object using class from previous class
        //b) Sort it using any two fields  using stream.
        //b) Filter it by any two fields custom filter.
        //c) Collect it to List with *main field(s).

        //a) Generate 10 random object using class from previous class
        List<Person> persons = generatePersons();
        System.out.println(persons);

        //b) Sort it using any two fields  using stream.
        System.out.println(persons.stream().sorted(Comparator.comparing(Person::getName)).collect(Collectors.toList()));
        System.out.println(persons.stream().sorted(Comparator.comparing(Person::getAge)).collect(Collectors.toList()));

        //b) Filter it by any two fields custom filter.
        System.out.println(persons.stream().filter(u -> (u.getAge() > 33 & u.getAge() < 55)).collect(Collectors.toList()));
        System.out.println(persons.stream().filter(u -> u.getName().startsWith("A")).collect(Collectors.toList()));

        //c) Collect it to List with *main field(s).
        System.out.println(persons.stream().map(Person::getName).collect(Collectors.toList()));
    }

    public static List<Person> generatePersons(){
        List<Person> persons = new ArrayList<>();
        Faker faker = new Faker();
        for (int i = 0; i < 10; i++) {
            Map<String, String> address = new HashMap<>();
            address.put("zip", faker.address().zipCode());
            address.put("state", faker.address().stateAbbr());
            address.put("city", faker.address().city());

            String name = faker.name().firstName();
            int age = faker.number().numberBetween(18, 60);

            persons.add(new Person(name, age, address));
        }
        return persons;
    }
}
