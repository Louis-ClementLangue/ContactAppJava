package dataBase;

import typeData.Person;

import java.sql.*;
import java.util.ArrayList;

public class PersonDAO {

    public ArrayList<Person> listPersonByLastname(){
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

    public ArrayList<Person> searchPersonByLastName(String lastName){
        ArrayList<Person> byLastname = new ArrayList<Person>();
        try (Connection connection = DataSourceFactory.getConnexion()){
            try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM person WHERE lastName= ? ORDER BY lastname")){
                statement.setString(1, lastName);
                try (ResultSet resultSet = statement.executeQuery()){
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

    public ArrayList<Person> searchPersonByFirstName(String firstName){
        ArrayList<Person> byFirstname = new ArrayList<Person>();
        try (Connection connection = DataSourceFactory.getConnexion()){
            try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM person WHERE firstName= ? ORDER BY lastname")){
                statement.setString(1, firstName);
                try (ResultSet resultSet = statement.executeQuery()){
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
                        byFirstname.add(person);
                    }
                }
            }
        } catch (SQLException e){
            throw new RuntimeException("Error reading", e);
        }
        return byFirstname;
    }

    public ArrayList<Person> searchPersonByNickName(String firstName){
        ArrayList<Person> byNickname = new ArrayList<Person>();
        try (Connection connection = DataSourceFactory.getConnexion()){
            try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM person WHERE nickName= ? ORDER BY lastname")){
                statement.setString(1, firstName);
                try (ResultSet resultSet = statement.executeQuery()){
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
                        byNickname.add(person);
                    }
                }
            }
        } catch (SQLException e){
            throw new RuntimeException("Error reading", e);
        }
        return byNickname;
    }

}
