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

        String username = userNameTextField.getText();
        String password = passwordField.getText();

        if(authorizationCheck(username, password)) {
            try {
                DCSUtilityApplication dcsUtilityApplication = new DCSUtilityApplication();
                dcsUtilityApplication.changeScene("main-view.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            confirmationLabel.setText("Incorrect User ID/Password combination!");
        }
    }

    public boolean authorizationCheck(String username, String password) {
        if(username.equals("admin") && password.equals("fall2021")) {
            return true;
        } else {
            return false;
        }
    }

}
