package ru.jdk;

import com.imir.dao.PersonDao;
import com.imir.entity.Person;
import ru.imir.PersonService;

import java.io.IOException;
import java.util.List;

public class View {
    PersonService personService = new PersonService();

    public List receiveListPersons() throws IOException {
        return personService.listAllPersons();
    }

    public String infoAboutPersonById(Long id) throws IOException {
        return String.valueOf(personService.getPerson(id));
    }

    public void changePersonName(Long id, String name) {
        try {
            personService.setPersonName(id, name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        View view = new View();
        try {
            view.receiveListPersons();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(view.infoAboutPersonById(8553213032146015585L));
        } catch (IOException e) {
            e.printStackTrace();
        }

        view.changePersonName(8553213032146015585L, "Alex");
        try {
            System.out.println(view.receiveListPersons());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
