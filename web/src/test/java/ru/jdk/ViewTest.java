package ru.jdk;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static ru.jdk.View.createPerson;

public class ViewTest {

    @Test
    public void createPersonTest() {
        assertNotNull(createPerson());
    }
}
