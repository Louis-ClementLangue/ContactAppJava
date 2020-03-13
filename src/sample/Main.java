package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import service.StageService;

import java.io.IOException;

public class Main extends Application {

    private void showHomeScreen() throws IOException {
        // Load our first file
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("homescreen.fxml"));
        // get it into a object file and create a scene from it
        AnchorPane rootAnchorPane = loader.load();
        Scene scene = new Scene(rootAnchorPane);
        // get the primary stage and put the first scene on the stage
        Stage ps = StageService.getInstance().getPrimaryStage();
        ps.setScene(scene);
        // Curtains up !
        ps.show();
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("homescreen.fxml"));
        primaryStage.setTitle("Contact App");
        StageService.getInstance().setPrimaryStage(primaryStage);
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
        try {
            this.showHomeScreen();
        } catch (IOException e) {
            System.out.println("too bad !");
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
