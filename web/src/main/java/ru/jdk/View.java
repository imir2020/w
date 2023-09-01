package ru.jdk;

import com.imir.entity.Person;

public class View {
    public static Person createPerson() {
        return new Person();
    }

    public static void main(String[] args) {
        Person person = createPerson();
        person.setName("Alex");
        System.out.println(person);
    }
}
