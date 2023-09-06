package com.imir.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.imir.entity.Person;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class PersonDao {
    private static final String PATH_NAME = "C:\\Users\\Admin\\IdeaProjects\\MavenMultiModAPI\\database" +
            "\\src\\main\\resources\\j_son.json";
    private static final int AMOUNT_PERSON = 10;

    public Optional<Person> findById(Long id) throws IOException {
        List<Person> list = readDataFromFile();
        Person person = null;
        for (Person p : list) {
            if (p.getId() == id) {
                person = p;
                break;
            }
        }
        return Optional.of(person);
    }

    static List<Person> createTestData() {
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < AMOUNT_PERSON; i++) {
            Person person = new Person();
            long id = new Random().nextLong(1, Long.MAX_VALUE);
            String name = i + "Dima" + i;
            person.setName(name);
            person.setId(id);
            list.add(person);
        }
        return list;
    }

    public void writeTestDataFile() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(PATH_NAME), createTestData());
    }

    public List<Person> readDataFromFile() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(PATH_NAME), new TypeReference<>() {});
    }

    public void writeDataToFile(Long id, String name) throws IOException {
        List<Person> list = readDataFromFile();
        for (Person p :list) {
            if (p.getId() == id) {
                p.setName(name);
                break;
            }
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(PATH_NAME), list);
    }

    public static void main(String[] args) throws IOException {
//        PersonDao person = new PersonDao();
//        createTestData();
//        person.writeTestDataFile();
//
//        List<Person> list = person.readDataFromFile();
//        for (Person p : list) {
//            System.out.println(p);
//        }
    }
}
