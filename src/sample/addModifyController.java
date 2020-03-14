package sample;

import dataBase.PersonDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import service.StageService;
import typeData.Person;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class addModifyController implements Initializable {
    public void handleback(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("homescreen.fxml"));
        AnchorPane rootAnchorPane = loader.load();
        Scene scene = new Scene(rootAnchorPane);
        Stage ps = StageService.getInstance().getPrimaryStage();
        ps.setScene(scene);
    }
    @FXML
    public javafx.scene.control.TextField firstname;

    @FXML
    public javafx.scene.control.TextField lastname;

    @FXML
    public javafx.scene.control.TextField nickname;

    @FXML
    public javafx.scene.control.TextField phonenumber;

    @FXML
    public javafx.scene.control.TextField address;

    @FXML
    public javafx.scene.control.TextField mail;

    public int id;

    @FXML
    public javafx.scene.control.DatePicker birthday;

    public void handlemodify(ActionEvent actionEvent) throws IOException {
        Person Personmodified = new Person();
        Personmodified.setId(id);
        if (firstname!= null){ Personmodified.setFirstname(firstname.getText());}
        if (lastname != null) {Personmodified.setLastname(lastname.getText());}
        if(nickname != null) {Personmodified.setNickname(nickname.getText());}
        if(phonenumber != null) {Personmodified.setPhoneNumber(phonenumber.getText());}
        if(address != null) {Personmodified.setAdress(address.getText());}
        if(mail !=null){ Personmodified.setEmailAddress(mail.getText());}
        if(birthday.getValue() == null){Personmodified.setBirthDate(null);System.out.println("Wesh");}else if(birthday.getValue() !=null){Personmodified.setBirthDate(java.sql.Date.valueOf(birthday.getValue()));}
        PersonDAO personDAO = new PersonDAO();
        personDAO.updatePerson(Personmodified);

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("listview.fxml"));
        AnchorPane rootAnchorPane = loader.load();
        Scene scene = new Scene(rootAnchorPane);
        Stage ps = StageService.getInstance().getPrimaryStage();
        ps.setScene(scene);
    }
    public void getPersonToModify(Person person){
    firstname.setText(person.getFirstname());
    lastname.setText(person.getLastname());
    nickname.setText(person.getNickname());
    phonenumber.setText(person.getPhoneNumber());
    address.setText(person.getAdress());
    mail.setText(person.getEmailAddress());
    if(person.getBirthDate()!=null){birthday.setValue(person.getBirthDate().toLocalDate());}
    id= person.getId();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void delete(ActionEvent actionEvent) throws IOException {
        Person Personmodified = new Person();
        Personmodified.setId(id);
        PersonDAO personDAO = new PersonDAO();
        personDAO.deletePerson(Personmodified);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("listview.fxml"));
        AnchorPane rootAnchorPane = loader.load();
        Scene scene = new Scene(rootAnchorPane);
        Stage ps = StageService.getInstance().getPrimaryStage();
        ps.setScene(scene);

    }
}
