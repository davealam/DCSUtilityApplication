package dalam.dcsutilitycontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class MainViewController {

    @FXML
    TabPane tabPane;

    @FXML
    TextField templateConfigurationFilePath;

    @FXML
    Label templateConfigurationLabel;

    @FXML
    Button templateConfigurationChooseButton;

    @FXML
    TextField fullConfigurationsFilePath;

    @FXML
    Label fullConfigurationsLabel;

    @FXML
    Button fullConfigurationsChooseButton;

    @FXML
    Button submitButton;


    public String chooseTemplateConfigurationButtonClick() {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Template Configuration File");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter(
                "Configuration Template Files", "*.xml"));

        Stage stage = (Stage) tabPane.getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(stage);

        templateConfigurationFilePath.setText(selectedFile.toString());

        return "null";
    }

}
