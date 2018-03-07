package booking;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
        PersonDaoImpl pdi = new PersonDaoImpl();

        /**Create table. Note that you can always run this
         * method. Table will be created only once (if it doesn't exist)**/
        pdi.createPersonTable();

        /**Insert a new record. Create a new Person instance and just
         * pass it as an argument in "insert" method**/
        Person person = new Person("John","Johnson");
        pdi.insert(person);

        /**Select by id**/
        Person personSelect = pdi.selectById(2);
        System.out.println(personSelect.getId()+", "+personSelect.getFirstName()+", "+personSelect.getLastName());

        /**Delete person by id**/
        pdi.delete(3);

        /**Update person**/
        Person personUpdate = new Person("Tom","Johnson");
        pdi.update(personUpdate,1);

        /**Select all persons**/
        List<Person> persons = pdi.selectAll();
        /**To retrieve values, you will have to use "for each" loop
         * to iterate through list**/
        for(Person p : persons) {
            System.out.println(p.getId()+", "+p.getFirstName()+", "+p.getLastName());
        }
    }
}
