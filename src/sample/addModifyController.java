package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import service.StageService;

import java.io.IOException;

public class addModifyController {
    public void handleback(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("homescreen.fxml"));
        AnchorPane rootAnchorPane = loader.load();
        Scene scene = new Scene(rootAnchorPane);
        Stage ps = StageService.getInstance().getPrimaryStage();
        ps.setScene(scene);
    }

    public void handlemodify(ActionEvent actionEvent) {
    }
}
