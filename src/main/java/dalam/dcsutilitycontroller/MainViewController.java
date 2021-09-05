package dalam.dcsutilitycontroller;

import dalam.dcsutilitymodel.functionality.StandardizeTests;
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
    private TabPane tabPane;

    @FXML
    private TextField templateConfigurationFilePath;

    @FXML
    private Label templateConfigurationLabel;

    @FXML
    private Button templateConfigurationChooseButton;

    @FXML
    private TextField configurationsFilePath;

    @FXML
    private Label fullConfigurationsLabel;

    @FXML
    private Button fullConfigurationsChooseButton;

    @FXML
    private Button submitButton;

    @FXML
    private Label confirmationLabel;

    //File path String values
    private String templateConfigurationFilePathValue;
    private String configurationsFilePathValue;

    @FXML
    //Choose Template Configuration file on button click
    public void chooseTemplateConfigurationButtonClick() {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Template Configuration File");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter(
                "Configuration Template Files", "*.xml"));

        Stage stage = (Stage) tabPane.getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(stage);

        //Display selected file path and set chosen Template Configuration file's path
        templateConfigurationFilePath.setText(selectedFile.getAbsolutePath());
        this.templateConfigurationFilePathValue = selectedFile.getAbsolutePath();
    }

    @FXML
    //Choose Configurations file on button click
    public void chooseConfigurationsButtonClick() {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Configurations File");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter(
                "Configurations Files", "*.xml"));

        Stage stage = (Stage) tabPane.getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(stage);

        //Set chosen Configurations file's path
        configurationsFilePath.setText(selectedFile.getAbsolutePath());
        this.configurationsFilePathValue = selectedFile.getAbsolutePath();
    }

    @FXML
    //Execute standardization of Configurations file based on tests in the supplied Template Configuration file
    public void submitButtonClick() {
        if(templateConfigurationFilePathValue != null && templateConfigurationFilePath != null) {
            StandardizeTests standardizeTests = new StandardizeTests();
            standardizeTests.standardize(templateConfigurationFilePathValue, configurationsFilePathValue);
            confirmationLabel.setText("Operation Completed Successfully");
        } else {
            confirmationLabel.setText("Operation failed, please provide both file paths");
        }
    }
}
