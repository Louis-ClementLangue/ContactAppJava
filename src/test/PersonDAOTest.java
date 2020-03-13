package test;

import dataBase.DataSourceFactory;
import dataBase.PersonDAO;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import typeData.Person;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PersonDAOTest {

    @Before
    public void initDataBase() throws SQLException {
        Connection connection = DataSourceFactory.getConnexion();
        Statement statement = connection.createStatement();
        statement.executeUpdate("DELETE from person");
        statement.executeUpdate("INSERT INTO person(lastname, firstname, nickname, phone_number, address, email_address, birth_date) " +
                "VALUES ('name12', 'name22', 'name32', '0123456789', 'isen2', 'address@isen.fr', '2020-05-02')");
        statement.executeUpdate("INSERT INTO person(lastname, firstname, nickname, phone_number, address, email_address, birth_date) " +
                "VALUES ('name11', 'name21', 'name31', '0123456789', 'isen1', 'address@isen.fr', '2020-05-02')");
        statement.executeUpdate("INSERT INTO person(lastname, firstname, nickname, phone_number, address, email_address, birth_date) " +
                "VALUES ('name13', 'name23', 'name33', '0123456789', 'isen3', 'address@isen.fr', '2020-05-02')");
        statement.close();
        connection.close();
    }

    @Test
    public void test1_selectAllPerson(){
        PersonDAO personDAO = new PersonDAO();
        ArrayList<Person> personList = personDAO.listPersonByLastname();
        assertThat(personList).hasSize(3).doesNotContainNull();
        assertThat(personList.get(0).getId()).isNotEqualTo(0);
        assertThat(personList.get(0).getLastname()).isEqualTo("name11");
        assertThat(personList.get(0).getFirstname()).isEqualTo("name21");
        assertThat(personList.get(0).getNickname()).isEqualTo("name31");
        assertThat(personList.get(0).getPhoneNumber()).isEqualTo("0123456789");
        assertThat(personList.get(0).getAdress()).isEqualTo("isen1");
        assertThat(personList.get(0).getEmailAddress()).isEqualTo("address@isen.fr");
    }

    @Test
    public void test2_selectOnePersonByLastName(){
        PersonDAO personDAO = new PersonDAO();
        ArrayList<Person> personList = personDAO.searchPersonByLastName("name11");
        assertThat(personList).hasSize(1);
        assertThat(personList.get(0).getId()).isNotEqualTo(0);
        assertThat(personList.get(0).getLastname()).isEqualTo("name11");
        assertThat(personList.get(0).getFirstname()).isEqualTo("name21");
        assertThat(personList.get(0).getNickname()).isEqualTo("name31");
        assertThat(personList.get(0).getPhoneNumber()).isEqualTo("0123456789");
        assertThat(personList.get(0).getAdress()).isEqualTo("isen1");
        assertThat(personList.get(0).getEmailAddress()).isEqualTo("address@isen.fr");
    }

    @Test
    public void test3_selectOnePersonByFisrtName(){
        PersonDAO personDAO = new PersonDAO();
        ArrayList<Person> personList = personDAO.searchPersonByFirstName("name21");
        assertThat(personList).hasSize(1);
        assertThat(personList.get(0).getId()).isNotEqualTo(0);
        assertThat(personList.get(0).getLastname()).isEqualTo("name11");
        assertThat(personList.get(0).getFirstname()).isEqualTo("name21");
        assertThat(personList.get(0).getNickname()).isEqualTo("name31");
        assertThat(personList.get(0).getPhoneNumber()).isEqualTo("0123456789");
        assertThat(personList.get(0).getAdress()).isEqualTo("isen1");
        assertThat(personList.get(0).getEmailAddress()).isEqualTo("address@isen.fr");
    }

    @Test
    public void test4_selectOnePersonByNickName(){
        PersonDAO personDAO = new PersonDAO();
        ArrayList<Person> personList = personDAO.searchPersonByNickName("name31");
        assertThat(personList).hasSize(1);
        assertThat(personList.get(0).getId()).isNotEqualTo(0);
        assertThat(personList.get(0).getLastname()).isEqualTo("name11");
        assertThat(personList.get(0).getFirstname()).isEqualTo("name21");
        assertThat(personList.get(0).getNickname()).isEqualTo("name31");
        assertThat(personList.get(0).getPhoneNumber()).isEqualTo("0123456789");
        assertThat(personList.get(0).getAdress()).isEqualTo("isen1");
        assertThat(personList.get(0).getEmailAddress()).isEqualTo("address@isen.fr");
    }

    @Test
    public void test5_addPerson(){
        Person person = new Person();
        person.setLastname("toyota");
        person.setFirstname("park");
        person.setNickname("car");
        person.setPhoneNumber("3630");
        person.setAdress("parking");
        person.setEmailAddress("toyota.gare@park.us");
        person.setBirthDate(new Date(2020, 5, 4));
        PersonDAO personDAO = new PersonDAO();
        personDAO.addPerson(person);
        ArrayList<Person> personList = personDAO.listPersonByLastname();
        assertThat(personList).hasSize(4).doesNotContainNull();
        assertThat(personList.get(3).getId()).isNotEqualTo(0);
        assertThat(personList.get(3).getLastname()).isEqualTo("toyota");
        assertThat(personList.get(3).getFirstname()).isEqualTo("park");
        assertThat(personList.get(3).getNickname()).isEqualTo("car");
        assertThat(personList.get(3).getPhoneNumber()).isEqualTo("3630");
        assertThat(personList.get(3).getAdress()).isEqualTo("parking");
        assertThat(personList.get(3).getEmailAddress()).isEqualTo("toyota.gare@park.us");
    }

    @Test
    public void test6_updatePerson(){
        Person person = new Person();
        person.setLastname("toyota");
        person.setFirstname("park");
        person.setNickname("car");
        person.setPhoneNumber("3630");
        person.setAdress("parking");
        person.setEmailAddress("toyota.gare@park.us");
        person.setBirthDate(new Date(2020, 5, 4));
        PersonDAO personDAO = new PersonDAO();
        personDAO.addPerson(person);
        person.setNickname("hybrid");
        personDAO.updatePerson(person);
        ArrayList<Person> personList = personDAO.listPersonByLastname();
        assertThat(personList).hasSize(4).doesNotContainNull();
        assertThat(personList.get(3).getId()).isNotEqualTo(0);
        assertThat(personList.get(3).getLastname()).isEqualTo("toyota");
        assertThat(personList.get(3).getFirstname()).isEqualTo("park");
        assertThat(personList.get(3).getNickname()).isEqualTo("hybrid");
        assertThat(personList.get(3).getPhoneNumber()).isEqualTo("3630");
        assertThat(personList.get(3).getAdress()).isEqualTo("parking");
        assertThat(personList.get(3).getEmailAddress()).isEqualTo("toyota.gare@park.us");
    }
}