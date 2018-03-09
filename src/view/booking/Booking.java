package view.booking;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.login.RegisterController;

public class Booking extends Application {
    
    public static void main(String[] args) {
        Application.launch(Booking.class, args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("booking.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        BookingController controller = (BookingController) fxmlLoader.getController();
        controller.initTable();
        stage.setTitle("Car Rental System -- Searching");
        stage.setScene(new Scene(root, 800, 600));
        stage.show();
    }
}
