package com.imir.dao;

import com.imir.entity.Person;

import java.util.Optional;

public class PersonDao {
    public Optional<Person> findById(Long id){
        Person person = new Person();
        person.setName("Dima");
        return Optional.of(person);
    }
}
