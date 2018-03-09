package AdminRequests;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.adminRequests.RequestsImpl;
import model.car.Car;
import model.order.Order;
import javafx.scene.control.cell.PropertyValueFactory;


import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.util.List;

public class AdminRequestsControllers {

        Stage stage;

        @FXML
        TableView table ;
        TableColumn order_ID ;
        TableColumn customerName ;
        TableColumn car_type ;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    TableView getTable ()
        {
            table.getColumns().addAll(order_ID,customerName,car_type);
            order_ID.setCellValueFactory(new PropertyValueFactory<Order,Integer>("order_ID"));
            customerName.setCellValueFactory(new PropertyValueFactory<Order,String>("customerName"));
            car_type.setCellValueFactory(new PropertyValueFactory<Order,String>("car_type"));

            RequestsImpl databaseQuery = new RequestsImpl();

            List<Order> orders = databaseQuery.selectAllOrders();

            ObservableList<Order> opsOrders = FXCollections.observableArrayList(orders); // FXCollections.observableArrayList(databaseQuery.getAllCars());

            table.setItems(opsOrders);

            return table;

        }

}
