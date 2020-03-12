package test;

import dataBase.PersonDAO;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.Assert.*;

public class PersonDAOTest {

    @Test
    public void three() {
        PersonDAO personDAO = new PersonDAO();
        assertThat(personDAO.three()).isEqualTo(3);
    }
}