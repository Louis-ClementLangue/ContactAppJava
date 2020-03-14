package sample;

import dataBase.PersonDAO;
import export.VCard;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import service.StageService;
import typeData.Person;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ListViewController implements Initializable {
    public void handleAdd(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("addelement.fxml"));
        AnchorPane rootAnchorPane = loader.load();
        Scene scene = new Scene(rootAnchorPane);
        Stage ps = StageService.getInstance().getPrimaryStage();
        ps.setScene(scene);
    }

    public TableView<Person> tableview;
    public TableColumn<Person, String> colfirstname;
    public TableColumn<Person, String> collastname;
    public Label firstnamefield;
    public Label lastnamefield;
    public Label nicknamefield;
    public Label numberfield;
    public Label adressefield;
    public Label mailfield;
    public Label birthdayfield;
    public TextField searchfield;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colfirstname.setCellValueFactory(new PropertyValueFactory<Person, String>("firstname"));
        collastname.setCellValueFactory(new PropertyValueFactory<Person, String>("lastname"));
        tableview.setItems(observableList);

    }

    ObservableList<Person> observableList = FXCollections.observableList(
            new PersonDAO().listPersonByLastname());

    public void display(MouseEvent mouseEvent) {
        Person person = tableview.getSelectionModel().getSelectedItem();
        firstnamefield.setText(person.getFirstname());
        lastnamefield.setText(person.getLastname());
        nicknamefield.setText(person.getNickname());
        numberfield.setText(person.getPhoneNumber());
        adressefield.setText(person.getAdress());
        mailfield.setText(person.getEmailAddress());
    }

    public void modify(ActionEvent actionEvent) throws IOException {
        Person persontomodify = tableview.getSelectionModel().getSelectedItem();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("modifyelement.fxml"));

        AnchorPane rootAnchorPane = loader.load();
        addModifyController id = loader.getController();
        id.getPersonToModify(persontomodify);
        Scene scene = new Scene(rootAnchorPane);
        Stage ps = StageService.getInstance().getPrimaryStage();
        ps.setScene(scene);
    }

   /* ObservableList<Person> observableLastNameList = FXCollections.observableList(
            new PersonDAO().searchPersonByLastname(searchfield.getText()));*/
    public void search(ActionEvent actionEvent) {
        PersonDAO person = new PersonDAO();
        ObservableList<Person> observableLastNameList = FXCollections.observableList(person.searchPersonByLastName(searchfield.getText()));
        ObservableList<Person> observableFirstNameList = FXCollections.observableList(person.searchPersonByFirstName(searchfield.getText()));
        ObservableList<Person> observableNickNameList = FXCollections.observableList(person.searchPersonByNickName(searchfield.getText()));
        colfirstname.setCellValueFactory(new PropertyValueFactory<Person, String>("firstname"));
        collastname.setCellValueFactory(new PropertyValueFactory<Person, String>("lastname"));
        if(person.searchPersonByLastName(searchfield.getText()).size()!=0){
            tableview.setItems(observableLastNameList);
        }

        else if (person.searchPersonByFirstName(searchfield.getText()).size()!=0){
            tableview.setItems(observableFirstNameList);
        }

        else if(person.searchPersonByNickName(searchfield.getText()).size()!=0){
            tableview.setItems(observableNickNameList);
        }
        else {
            tableview.setItems(observableList);
        }
    }

    public void export(ActionEvent actionEvent) {
        boolean done = true;
        PersonDAO personDAO = new PersonDAO();
        ArrayList<Person> personArrayList = personDAO.listPersonByLastname();
        for (Person i:personArrayList){
            VCard vCard = new VCard(i);
            if(vCard.exportFile() == false){
                done = false;
            }
        }
    }
}
