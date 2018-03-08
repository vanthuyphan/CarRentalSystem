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
	private Text actiontarget1;
	@FXML
	private TextField emailField;
	@FXML
	private TextField passwordField;

	Stage stage;

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
			actiontarget.setText("Email or password incorrect");
			passwordField.setText("");
		}
	}

	@FXML
	protected void handleSignUpAction(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("register.fxml"));
		Parent root = (Parent) fxmlLoader.load();
		RegisterController cont = (RegisterController) fxmlLoader.getController();
		cont.setStage(stage);
		stage.setTitle("Car Rental System");
		stage.setScene(new Scene(root, 400, 275));
		stage.show();
	}

	private boolean Login(String email, String password) {
		UserManImpl userMan = new UserManImpl();
		return userMan.login(email, password);
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public void setEmail(String text) {
		emailField.setText(text);		
	}

}
