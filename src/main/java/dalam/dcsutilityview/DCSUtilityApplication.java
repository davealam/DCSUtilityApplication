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
//        FXMLLoader fxmlLoader = new FXMLLoader(DCSUtilityApplication.class.getResource("login-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load());

        Parent root = FXMLLoader.load(getClass().getResource("login-view.fxml"));
        primaryStage.setTitle("DCS Utility Application");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    public void changeScene(String viewFXML) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(viewFXML));
        stage.getScene().setRoot(pane);

    }

    public static void main(String[] args) {
        launch();
    }
}