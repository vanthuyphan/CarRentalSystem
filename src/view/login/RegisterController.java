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
import model.user.User;
import model.user.UserManImpl;

public class RegisterController {
	@FXML
	private Text actiontarget;
	@FXML
	private TextField nameField;
	@FXML
	private TextField emailField;
	@FXML
	private TextField passwordField;
	@FXML
	private TextField conPasswordField;

	Stage primaryStage;

	@FXML
	protected void handleRegisterAction(ActionEvent event) throws IOException {

		if (nameField.getText().isEmpty()) {
			actiontarget.setText("Please enter name");
			return;
		}

		if (emailField.getText().isEmpty()) {
			actiontarget.setText("Please enter email");
			return;
		}

		if (passwordField.getText().isEmpty()) {
			actiontarget.setText("Please enter password");
			return;
		}

		if (conPasswordField.getText().isEmpty()) {
			actiontarget.setText("Passwords do not match");
			return;
		}

		if (!conPasswordField.getText().equals(passwordField.getText())) {
			actiontarget.setText("Passwords do not match");
			return;
		}

		Register(nameField.getText(), emailField.getText(), passwordField.getText());
		actiontarget.setText("reg ok");
		// Call Main Screen

	}

	@FXML
	protected void handleBackAction(ActionEvent event) throws IOException {
		// actiontarget.setText("back ok");
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
		Parent root = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.setTitle("Car Rental System");
		stage.setScene(new Scene(root, 400, 275));
		stage.show();
	}

	private void Register(String name, String email, String password) {
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		user.setType(1);
		UserManImpl userMan = new UserManImpl();
		userMan.insert(user);
	}

	public void start(Stage pStage) throws Exception {

		primaryStage = pStage;

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("register.fxml"));
		Parent root = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.setTitle("Car Rental System");
		stage.setScene(new Scene(root, 400, 275));
		stage.show();

		primaryStage.hide();
	}

}
