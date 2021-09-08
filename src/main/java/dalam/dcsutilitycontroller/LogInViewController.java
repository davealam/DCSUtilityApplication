package dalam.dcsutilitycontroller;

import dalam.dcsutilityview.DCSUtilityApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LogInViewController {

    @FXML
    private Label headerLabel;

    @FXML
    private TextField userNameTextField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button signInButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Label confirmationLabel;

    public void signInButtonClick() {

        //Obtain entered username and password from text fields
        String username = userNameTextField.getText();
        String password = passwordField.getText();

        //Check to see if combination is valid and authorized for access
        if(authorizationCheck(username, password)) {
            try {
                DCSUtilityApplication dcsUtilityApplication = new DCSUtilityApplication();
                dcsUtilityApplication.changeScene("main-view.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {

            //If wrong combination, flash message and clear fields for another try
            confirmationLabel.setText("Incorrect User ID/Password combination!");
            username = password = null;
            userNameTextField.clear();
            passwordField.clear();

        }
    }

    public boolean authorizationCheck(String username, String password) {
        if(username.equals("admin") && password.equals("fall2021")) {
            return true;
        } else {
            return false;
        }
    }

    @FXML
    public void cancelButtonClick() {
        DCSUtilityApplication dcsUtilityApplication = new DCSUtilityApplication();
        dcsUtilityApplication.stop();
    }

}
