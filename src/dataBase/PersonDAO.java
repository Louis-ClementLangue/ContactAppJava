package dataBase;

import typeData.Person;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PersonDAO {

    public ArrayList<Person> listPersonnByLastname(){
        ArrayList<Person> byLastname = new ArrayList<Person>();
        try (Connection connection = DataSourceFactory.getConnexion()){
            try(Statement statement = connection.createStatement()){
                try (ResultSet resultSet = statement.executeQuery("SELECT * FROM person ORDER BY lastname")){
                    while (resultSet.next()){
                        Person person = new Person();
                        person.setId(resultSet.getInt("idperson"));
                        person.setLastname(resultSet.getString("lastname"));
                        person.setFirstname(resultSet.getString("firstname"));
                        person.setNickname(resultSet.getString("nickname"));
                        person.setPhoneNumber(resultSet.getString("phone_number"));
                        person.setAdress(resultSet.getString("address"));
                        person.setEmailAddress(resultSet.getString("email_address"));
                        person.setBirthDate(resultSet.getDate("birth_date"));
                        byLastname.add(person);
                    }
                }
            }
        } catch (SQLException e){
            throw new RuntimeException("Error reading", e);
        }
        return byLastname;
    }

}
