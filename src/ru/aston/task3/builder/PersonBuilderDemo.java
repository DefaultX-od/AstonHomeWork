package ru.aston.task3.builder;

import java.util.Date;
import java.util.List;

public class PersonBuilderDemo {
    public static void main(String[] args) {
        final List<Person> people = List.of(
                Person.builder("Джон", "Доу", new Date(105, 11, 12),"male").build(),
                Person.builder("Лия", "Доу", new Date(107, 11, 12),"female").cellPhone(88005553555L).build(),
                Person.builder("Лия", "Доу", new Date(107, 11, 12),"female").cellPhone(88005553555L).build()
        );

        people.forEach(System.out::println);
    }
}
