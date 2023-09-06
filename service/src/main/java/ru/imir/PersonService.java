package ru.imir;

import com.imir.dao.PersonDao;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class PersonService {
    private final PersonDao personDao = new PersonDao();

    public Optional<PersonDto> getPerson(Long id) throws IOException {
        return personDao.findById(id).map(i -> new PersonDto(i.getName()));
    }

    public void setPersonName(Long id, String newName) throws IOException {
        Optional<PersonDto> buf = getPerson(id);
        buf.ifPresent(name -> name.setName(newName));
        personDao.writeDataToFile(id, buf.get().getName());
    }

    public List listAllPersons() throws IOException {
        return personDao.readDataFromFile();
    }

    public static void main(String[] args) throws IOException {
        PersonService p = new PersonService();
        System.out.println(p.getPerson(7369973181362102382L));
        p.setPersonName(7369973181362102382L,"Dmitriy");
        System.out.println(p.listAllPersons());
    }


}
