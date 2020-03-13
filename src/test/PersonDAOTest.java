package test;

import dataBase.DataSourceFactory;
import dataBase.PersonDAO;
import org.junit.Before;
import org.junit.Test;
import typeData.Person;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

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
    public void selectAllPersonTest(){
        PersonDAO personDAO = new PersonDAO();
        ArrayList<Person> personList = personDAO.listPersonByLastname();
        assertThat(personList).hasSize(3).doesNotContainNull();
        assertThat(personList.get(0).getLastname()).isEqualTo("name11");
        assertThat(personList.get(0).getFirstname()).isEqualTo("name21");
        assertThat(personList.get(0).getNickname()).isEqualTo("name31");
        assertThat(personList.get(0).getPhoneNumber()).isEqualTo("0123456789");
        assertThat(personList.get(0).getAdress()).isEqualTo("isen1");
        assertThat(personList.get(0).getEmailAddress()).isEqualTo("address@isen.fr");
    }

    @Test
    public void selectOnePersonByLastName(){
        PersonDAO personDAO = new PersonDAO();
        ArrayList<Person> personList = personDAO.searchPersonByLastName("name11");
        assertThat(personList).hasSize(1);
        assertThat(personList.get(0).getLastname()).isEqualTo("name11");
        assertThat(personList.get(0).getFirstname()).isEqualTo("name21");
        assertThat(personList.get(0).getNickname()).isEqualTo("name31");
        assertThat(personList.get(0).getPhoneNumber()).isEqualTo("0123456789");
        assertThat(personList.get(0).getAdress()).isEqualTo("isen1");
        assertThat(personList.get(0).getEmailAddress()).isEqualTo("address@isen.fr");
    }

    @Test
    public void selectOnePersonByFisrtName(){
        PersonDAO personDAO = new PersonDAO();
        ArrayList<Person> personList = personDAO.searchPersonByFirstName("name21");
        assertThat(personList).hasSize(1);
        assertThat(personList.get(0).getLastname()).isEqualTo("name11");
        assertThat(personList.get(0).getFirstname()).isEqualTo("name21");
        assertThat(personList.get(0).getNickname()).isEqualTo("name31");
        assertThat(personList.get(0).getPhoneNumber()).isEqualTo("0123456789");
        assertThat(personList.get(0).getAdress()).isEqualTo("isen1");
        assertThat(personList.get(0).getEmailAddress()).isEqualTo("address@isen.fr");
    }

    @Test
    public void selectOnePersonByNickName(){
        PersonDAO personDAO = new PersonDAO();
        ArrayList<Person> personList = personDAO.searchPersonByNickName("name31");
        assertThat(personList).hasSize(1);
        assertThat(personList.get(0).getLastname()).isEqualTo("name11");
        assertThat(personList.get(0).getFirstname()).isEqualTo("name21");
        assertThat(personList.get(0).getNickname()).isEqualTo("name31");
        assertThat(personList.get(0).getPhoneNumber()).isEqualTo("0123456789");
        assertThat(personList.get(0).getAdress()).isEqualTo("isen1");
        assertThat(personList.get(0).getEmailAddress()).isEqualTo("address@isen.fr");
    }
}