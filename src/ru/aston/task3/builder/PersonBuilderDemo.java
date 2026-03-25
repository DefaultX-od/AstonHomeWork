package ru.aston.task3.builder;

import java.util.Date;
import java.util.List;

public class PersonBuilderDemo {
    public static void main(String[] args) {
        final List<Person> people = List.of(
                new Person.Builder("Джон", "Доу", new Date(105, 11, 12),"male").build(),
                new Person.Builder("Лия", "Доу", new Date(107, 11, 12),"female").cellPhone(88005553555L).build(),
                new Person.Builder("Лия", "Доу", new Date(107, 11, 12),"female").cellPhone(88005553555L).build()
        );

        for (Person person : people){
            System.out.println(person);
        }
    }
}
