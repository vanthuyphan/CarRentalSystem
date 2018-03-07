package view.booking;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.car.Car;
import model.car.CarDaoImpl;

import java.util.List;

public class Booking extends Application {
    
    public static void main(String[] args) {
        Application.launch(Booking.class, args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("booking.fxml"));
        
        stage.setTitle("JavaFX Welcome");
        stage.setScene(new Scene(root, 300, 275));
        stage.show();


        // Test Code:
        CarDaoImpl pdi = new CarDaoImpl();

        /**Create table. Note that you can always run this
         * method. Table will be created only once (if it doesn't exist)**/
        pdi.createPersonTable();

        /**Insert a new record. Create a new Car instance and just
         * pass it as an argument in "insert" method**/
        Car car = new Car("John","Johnson");
        pdi.insert(car);

        /**Select by id**/
        Car carSelect = pdi.selectById(2);
        System.out.println(carSelect.getId()+", "+ carSelect.getFirstName()+", "+ carSelect.getLastName());

        /**Delete car by id**/
        pdi.delete(3);

        /**Update car**/
        Car carUpdate = new Car("Tom","Johnson");
        pdi.update(carUpdate,1);

        /**Select all cars**/
        List<Car> cars = pdi.selectAll();
        /**To retrieve values, you will have to use "for each" loop
         * to iterate through list**/
        for(Car p : cars) {
            System.out.println(p.getId()+", "+p.getFirstName()+", "+p.getLastName());
        }
    }
}
