package view.booking;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Booking extends Application {
    
    public static void main(String[] args) {
        Application.launch(Booking.class, args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("booking.fxml"));
        stage.setTitle("Car Searching");
        stage.setScene(new Scene(root, 800, 700));
        stage.show();
    }
}
