package dalam.dcsutilitycontroller;

import dalam.dcsutilitymodel.functionality.StandardizeTests;
import dalam.dcsutilityview.DCSUtilityApplication;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class MainViewController {

    @FXML
    private TabPane tabPane;

    //Standardize Product Tests tab
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
    private Button logOutButton;

    @FXML
    private Label confirmationLabel;

    //Generate Configurations File tab
    @FXML
    private TextField csvFilePathTAB2;

    @FXML
    private Button csvChooseButtonTAB2;

    @FXML
    private TextField templateConfigurationFilePathTAB2;

    @FXML
    private Button templateConfigurationChooseButtonTAB2;

    @FXML
    private TextField configurationsFilePathTAB2;

    @FXML
    private Button configurationsFilePathChooseButtonTAB2;

    @FXML
    private Button submitButtonTAB2;

    @FXML
    private Button logOutButtonTAB2;

    @FXML
    private Label confirmationLabelTAB2;

    @FXML
    private CheckBox appendToExistingCheckBoxTAB2;

    @FXML
    private Label configurationsLabelTAB2;

    //File path String values
    private String templateConfigurationFilePathValue;
    private String configurationsFilePathValue;


    public void initialize() {
        disableAppend(true);
    }

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

            //Clear file path values after performing operations, in case of consecutive operations
            templateConfigurationFilePathValue = configurationsFilePathValue = null;
            confirmationLabel.setText("Operation Successful");
        } else {
            confirmationLabel.setText("Please provide both file paths");
        }
    }

    @FXML
    //Log user out to sign in screen
    public void logOutButtonClick() {
        DCSUtilityApplication dcsUtilityApplication = new DCSUtilityApplication();
        try {
            dcsUtilityApplication.changeScene("login-view.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    //Enable/Disable appending Configuration list to pre existing Configurations list
    public void appendToExistingCheckBoxClick() {
        if(appendToExistingCheckBoxTAB2.isSelected()) {
            disableAppend(false);
        } else {
            disableAppend(true);
        }
    }

    //Enable or disable 'Append to existing' feature based on supplied boolean value
    public void disableAppend(boolean trueOrFalse) {
        configurationsFilePathChooseButtonTAB2.setDisable(trueOrFalse);
        configurationsLabelTAB2.setDisable(trueOrFalse);
        configurationsFilePathTAB2.setDisable(trueOrFalse);

    }
}
