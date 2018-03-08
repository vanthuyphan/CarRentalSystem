package view.login;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.user.UserManImpl;

public class LoginController {
	@FXML
	private Text actiontarget;
	@FXML
	private TextField emailField;
	@FXML
	private TextField passwordField;

	@FXML
	protected void handleSignInAction(ActionEvent event) throws IOException {

		if (emailField.getText().isEmpty() || passwordField.getText().isEmpty()) {
			actiontarget.setText("Please enter email and password");
			return;
		}
		if (Login(emailField.getText(), passwordField.getText())) {
			actiontarget.setText("Login ok");
			// Call Main Screen
		} else {
			actiontarget.setText("You may have entered an unknown email address or an incorrect password");
			passwordField.setText("");
		}
	}

	@FXML
	protected void handleSignUpAction(ActionEvent event) throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("register.fxml"));
		Parent root1 = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.setScene(new Scene(root1));
		stage.show();

	}

	private boolean Login(String email, String password) {
		UserManImpl userMan = new UserManImpl();
		return userMan.login(email, password);
	}

}
