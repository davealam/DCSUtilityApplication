package dalam.dcsutilitycontroller;

import dalam.dcsutilitymodel.functionality.DCSUtilityMarshaller;
import dalam.dcsutilitymodel.functionality.MassImportProducts;
import dalam.dcsutilitymodel.functionality.StandardizeTests;
import dalam.dcsutilitymodel.spcobjects.configurations.Configurations;
import dalam.dcsutilitymodel.spcobjects.configurations.configuration.Configuration;
import dalam.dcsutilityview.DCSUtilityApplication;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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
    private Button configurationsChooseButton;

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
    private String csvFilePathValueTAB2;
    private String templateConfigurationFilePathValueTAB2;
    private String configurationsFilePathValueTAB2;


    public void initialize() {
        disableAppend(true);
    }


    //--------------------'Standardize Tests' tab----------------------
    @FXML
    //Choose Template Configuration file on button click
    public void chooseTemplateConfigurationButtonClick() {

        String templateConfigurationFilePathString =
                generateFileChooser("Choose Template Configuration File",
                        "Configuration Template Files",
                        "*.xml");

        //Display selected file path and set chosen Template Configuration file's path
        templateConfigurationFilePath.setText(templateConfigurationFilePathString);
        this.templateConfigurationFilePathValue = templateConfigurationFilePathString;
    }

    @FXML
    //Choose Configurations file on button click
    public void chooseConfigurationsButtonClick() {

        String configurationsFilePathString =
                generateFileChooser("Choose Configurations File", "Configurations Files", "*.xml");

        //Display selected file path and set chosen Configurations file's path
        configurationsFilePath.setText(configurationsFilePathString);
        this.configurationsFilePathValue = configurationsFilePathString;
    }

    @FXML
    //Execute standardization of Configurations file based on tests in the supplied Template Configuration file
    public void submitButtonClick() {

        if(templateConfigurationFilePathValue != null && templateConfigurationFilePath != null) {

            StandardizeTests standardizeTests = new StandardizeTests();

            Configurations modifiedConfigurations =
                    standardizeTests.standardize(templateConfigurationFilePathValue, configurationsFilePathValue);

            String saveFilePath = generateSaveDialog();

            DCSUtilityMarshaller.marshallConfigurations(modifiedConfigurations, saveFilePath);

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
    //Choose CSV file on button click
    public void chooseCSVButtonTAB2Click() {

        String csvFilePathString =
                generateFileChooser("Choose CSV File", "CSV File", "*.csv");

        //Display selected file path and set chosen CSV file's path
        csvFilePathTAB2.setText(csvFilePathString);
        this.csvFilePathValueTAB2 = csvFilePathString;
    }


    //--------------------'Generate Configurations' tab (TAB2)-------------
    @FXML
    //Choose Template Configuration file on button click (2nd Tab)
    public void chooseTemplateConfigurationButtonTAB2Click() {

        String templateConfigurationFilePathString =
                generateFileChooser("Choose Template Configuration File", "Template File", "*.xml");

        //Display selected file path and set chosen Configuration template file's path
        templateConfigurationFilePathTAB2.setText(templateConfigurationFilePathString);
        this.templateConfigurationFilePathValueTAB2 = templateConfigurationFilePathString;

    }

    @FXML
    //Choose Configurations file to append to
    public void chooseConfigurationsButtonTAB2Click() {

        String configurationsFilePathString =
                generateFileChooser("Choose Configurations File", "Configurations Files", "*.xml");

        //Display selected file path and set chosen Configurations file's path
        configurationsFilePathTAB2.setText(configurationsFilePathString);
        this.configurationsFilePathValueTAB2 = configurationsFilePathString;
    }

    //Process files from submitted file paths
    @FXML
    public void submitButtonTAB2Click() {

        if(appendToExistingCheckBoxTAB2.isSelected()) {

            if((csvFilePathValueTAB2 != null)  && (templateConfigurationFilePathValueTAB2 != null) && (configurationsFilePathValueTAB2 != null)) {

                MassImportProducts massImportProducts = new MassImportProducts();

                ArrayList<Configuration> configurationList =
                        massImportProducts.generateConfigurationListFromCSV(csvFilePathValueTAB2, templateConfigurationFilePathValueTAB2);

                Configurations modifiedConfigurations =
                        massImportProducts.returnAppendedConfigurationsFile(configurationList, configurationsFilePathValueTAB2);

                String fileSaveLocation = generateSaveDialog();

                DCSUtilityMarshaller.marshallConfigurations(modifiedConfigurations, fileSaveLocation);

                confirmationLabelTAB2.setText("Operation successful");
            }

        } else {

            MassImportProducts massImportProducts = new MassImportProducts();

            ArrayList<Configuration> configurationList =
                    massImportProducts.generateConfigurationListFromCSV(
                            csvFilePathValueTAB2, templateConfigurationFilePathValueTAB2);

            Configurations modifiedConfigurations =
                    massImportProducts.returnNewConfigurationsFile(configurationList);

            String fileSaveLocation = generateSaveDialog();

            DCSUtilityMarshaller.marshallConfigurations(modifiedConfigurations,fileSaveLocation);

            confirmationLabelTAB2.setText("Operation successful");

        }
    }

    @FXML
    //Enable/Disable appending Configuration list to pre existing Configurations list
    public void appendToExistingCheckBoxTAB2Click() {
        if(appendToExistingCheckBoxTAB2.isSelected()) {
            disableAppend(false);
        } else {
            disableAppend(true);
        }
    }

    @FXML
    //Log user out to sign in screen
    public void logOutButtonTAB2Click() {
        DCSUtilityApplication dcsUtilityApplication = new DCSUtilityApplication();
        try {
            dcsUtilityApplication.changeScene("login-view.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //--------------------Methods--------------------
    //Enable or disable 'Append to existing' feature based on supplied boolean value
    public void disableAppend(boolean trueOrFalse) {
        configurationsFilePathChooseButtonTAB2.setDisable(trueOrFalse);
        configurationsLabelTAB2.setDisable(trueOrFalse);
        configurationsFilePathTAB2.setDisable(trueOrFalse);

    }

    //Method that generates file chooser dialog pane
    public String generateFileChooser(String title, String fileDescription, String fileExtension) {
        FileChooser fileOpen = new FileChooser();
        fileOpen.setTitle(title);
        fileOpen.getExtensionFilters().addAll(new FileChooser.ExtensionFilter(
                fileDescription, fileExtension));

        Stage stage = (Stage) tabPane.getScene().getWindow();
        File selectedFile = fileOpen.showOpenDialog(stage);

        //Return string value of chosen file's path
        return selectedFile.getAbsolutePath().toString();
    }

    //Method to allow user to choose save destination for resultant files
    public String generateSaveDialog() {
        FileChooser fileSave = new FileChooser();
        fileSave.setTitle("Save File:");
        fileSave.getExtensionFilters().addAll(new FileChooser.ExtensionFilter(
                "Configurations File", "*.xml"));

        Stage stage = (Stage) tabPane.getScene().getWindow();
        File saveFile = fileSave.showSaveDialog(stage);

        return saveFile.getAbsolutePath().toString();
    }
}
