package view.booking;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import model.car.Car;
import model.car.CarDaoImpl;
import model.order.OrderDaoImpl;
import model.user.User;

import java.util.List;
import java.util.Optional;

public class BookingController {
    @FXML
    private TextField carType;
    @FXML
    private TextField pickupDate;
    @FXML
    private TextField dropOffDate;
    @FXML
    private TextField provider;
    @FXML
    private TextField passengers;
    @FXML
    private TableView carTable;
    private User user;
    private OrderDaoImpl orderDao = new OrderDaoImpl();
    private Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
    private Alert alert = new Alert(Alert.AlertType.INFORMATION);


    @FXML
    protected void handleSearchButtonAction(ActionEvent event) {
        String _pickUpDate = pickupDate.getText();
        String _dropOffDate = dropOffDate.getText();
        String _provider = provider.getText();
        String _passengers = passengers.getText();

        //List<Car> results = new OrderDaoImpl().search(_pickUpDate, _dropOffDate, _provider, _passengers);
        List<Car> results = new CarDaoImpl().search();
        ObservableList<Car> oListStavaka = FXCollections.observableArrayList(results); // FXCollections.observableArrayList(databaseQuery.getAllCars());
        carTable.setItems(oListStavaka);

    }

    public void initTable() {
        TableColumn carType = new TableColumn("Car Type");
        TableColumn providerComp = new TableColumn("Provider Comp.");
        TableColumn passenger = new TableColumn("Passengers");
        TableColumn price = new TableColumn("Price");
        TableColumn color = new TableColumn("Color");
        TableColumn actions = new TableColumn("Rent");

        carTable.getColumns().addAll(carType, providerComp, passenger, price, color, actions);

        carType.setCellValueFactory(new PropertyValueFactory<Car, String>("CarType"));
        providerComp.setCellValueFactory(new PropertyValueFactory<Car, String>("ProviderComp"));
        passenger.setCellValueFactory(new PropertyValueFactory<Car, String>("Passenger"));
        price.setCellValueFactory(new PropertyValueFactory<Car, String>("Price"));
        color.setCellValueFactory(new PropertyValueFactory<Car, String>("Color"));
        actions.setCellValueFactory(new PropertyValueFactory<Car, Button>("Book"));


        actions.setCellFactory(
                new Callback<TableColumn<Car, Boolean>, TableCell<Car, Boolean>>() {
                    @Override
                    public TableCell<Car, Boolean> call(TableColumn<Car, Boolean> p) {
                        return new ButtonCell();
                    }

                });

        confirmation.setTitle("Confirmation");
        confirmation.setHeaderText("Are you sure you want to rent this car");
        confirmation.setContentText("Sure");
    }


    @FXML
    protected void handleResetButtonAction(ActionEvent event) {
        carType.clear();
        pickupDate.clear();
        dropOffDate.clear();
        provider.clear();
        passengers.clear();
    }

    public void setUser(User user) {
        this.user = user;
    }

    private class ButtonCell extends TableCell<Car, Boolean> {
        final Button cellButton = new Button("Rent");

        ButtonCell() {
            cellButton.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent t) {
                    Optional<ButtonType> result = confirmation.showAndWait();
                    if (result.get() == ButtonType.OK){
                        Car car = (Car) ButtonCell.this.getTableView().getItems().get(ButtonCell.this.getIndex());
                        createOrder(car, user);
                    } else {
                    }
                }
            });
        }

        @Override
        protected void updateItem(Boolean t, boolean empty) {
            super.updateItem(t, empty);
            if (!empty) {
                setGraphic(cellButton);
            }
        }
    }

    private void createOrder(Car car, User user) {
        orderDao.createOrder(car, user);
        alert.setTitle("Thank you!");
        alert.setHeaderText("Your order has been placed. We will get back to you shortly with further instruction");
        alert.show();
    }

}
