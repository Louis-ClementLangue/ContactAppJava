package sample;

import dataBase.PersonDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import service.StageService;
import typeData.Person;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

public class addElementController{
    public void handleback(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("homescreen.fxml"));
        AnchorPane rootAnchorPane = loader.load();
        Scene scene = new Scene(rootAnchorPane);
        Stage ps = StageService.getInstance().getPrimaryStage();
        ps.setScene(scene);
    }

    @FXML
    public TextField firstname;

    @FXML
    public TextField lastname;

    @FXML
    public TextField nickname;

    @FXML
    public TextField phonenumber;

    @FXML
    public TextField address;

    @FXML
    public TextField mail;

    @FXML
    public DatePicker birthday;


    public void handleadd(ActionEvent actionEvent) throws IOException {
        Person newPerson = new Person();
        if (firstname!= null){ newPerson.setFirstname(firstname.getText());}
        if (lastname != null) {newPerson.setLastname(lastname.getText());}
        if(nickname != null) {newPerson.setNickname(nickname.getText());}
        if(phonenumber != null) {newPerson.setPhoneNumber(phonenumber.getText());}
        if(address != null) {newPerson.setAdress(address.getText());}
        if(mail !=null){ newPerson.setEmailAddress(mail.getText());}
        if(birthday.getValue() == null){newPerson.setBirthDate(null);System.out.println("Wesh");}else if(birthday.getValue() !=null){newPerson.setBirthDate(java.sql.Date.valueOf(birthday.getValue()));}
        PersonDAO personDAO = new PersonDAO();
        personDAO.addPerson(newPerson);

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("listview.fxml"));
        AnchorPane rootAnchorPane = loader.load();
        Scene scene = new Scene(rootAnchorPane);
        Stage ps = StageService.getInstance().getPrimaryStage();
        ps.setScene(scene);
    }
}
