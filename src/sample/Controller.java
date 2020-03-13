package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import service.StageService;

import java.io.IOException;

public class Controller {
    public void handleList(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("listview.fxml"));
        AnchorPane rootAnchorPane = loader.load();
        Scene scene = new Scene(rootAnchorPane);
        Stage ps = StageService.getInstance().getPrimaryStage();
        ps.setScene(scene);
    }

    public void handleCreate(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("addelement.fxml"));
        AnchorPane rootAnchorPane = loader.load();
        Scene scene = new Scene(rootAnchorPane);
        Stage ps = StageService.getInstance().getPrimaryStage();
        ps.setScene(scene);
    }
}
