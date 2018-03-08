package view.login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Login extends Application {
    
    public static void main(String[] args) {
        Application.launch(Login.class, args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        
        stage.setTitle("Car Rental System");
        stage.setScene(new Scene(root, 400, 275));
        stage.show();
    }
}
