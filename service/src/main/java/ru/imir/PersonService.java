package ru.imir;

import com.imir.dao.PersonDao;
import com.imir.entity.Person;

import java.util.Optional;

public class PersonService {
    private final PersonDao personDao = new PersonDao();

    public Optional<PersonDto> getPerson(Long id) {
        return personDao.findById(id).map(i -> new PersonDto(i.getName()));
    }
}
