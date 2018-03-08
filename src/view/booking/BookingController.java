package view.booking;
 
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.List;

public class BookingController {
    @FXML private TextField carType;
    @FXML private TextField pickupDate;
    @FXML private TextField dropOffDate;
    @FXML private TextField provider;
    @FXML private TextField passengers;

    @FXML protected void handleSearchButtonAction(ActionEvent event) {
        System.out.println("Search" );
        System.out.println();
        System.out.println(pickupDate.getText());
        System.out.println(dropOffDate.getText());
        System.out.println(provider.getText());
        System.out.println(passengers.getText());
        List<Car> results = new CarDaoImpl().search(carType.getText(), pickupDate.getText(), dropOffDate.getText(), provider.getText(), passengers.getText());
    }

    @FXML protected void handleResetButtonAction(ActionEvent event) {
        carType.clear();
        pickupDate.clear();
        dropOffDate.clear();
        provider.clear();
        passengers.clear();
    }

}
