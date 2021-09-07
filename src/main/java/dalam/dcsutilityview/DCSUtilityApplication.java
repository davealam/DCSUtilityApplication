package dalam.dcsutilityview;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DCSUtilityApplication extends Application {

    private static Stage stage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.stage = primaryStage;
        primaryStage.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("login-view.fxml"));
        primaryStage.setTitle("DCS Utility Application");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    @Override
    public void stop() {
        stage.close();
    }

    public void changeScene(String viewFXML) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(viewFXML));
        stage.getScene().setRoot(pane);

    }

    public static void main(String[] args) {
        launch();
    }
}