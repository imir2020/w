package ru.jdk;

import org.junit.Test;
import ru.imir.PersonService;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;



public class ViewTest {
    private View view = new View();


    @Test
    public void receiveListPersonsTest(){
        try {
            assertNotNull(view.receiveListPersons());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void infoAboutPersonByIdTest(){
        try {
            assertNotNull(view.infoAboutPersonById(7369973181362102382L));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
