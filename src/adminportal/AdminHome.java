package adminportal;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.car.Car;
import model.car.CarDaoImpl;

import java.util.List;

//import model.adminstructures;
//import model.model.car.Car;

public class AdminHome extends Application {
    final TableView table = new TableView();

    TextField carTypeTextf = new TextField();
    TextField providerCompTextf = new TextField();
    TextField passengerTextf = new TextField();
    TextField priceTextf = new TextField();
    TextField colorTextf = new TextField();
    TextField isAvailableTextf = new TextField();
    TextField statusTextf = new TextField();

    Text errorText = new Text();

    public static void main(String[] args) {
        // launch(args);
        Application.launch(AdminHome.class, args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("AdminHome.fxml"));
        primaryStage.setTitle("Admin Portal (Car Rental System)");

        Text CarsInfo = new Text(" Cars Information:-");

        GridPane grid1 = new GridPane();
        grid1.setHgap(10);
        grid1.add(CarsInfo, 0, 0);
        grid1.add(GetCarsInfo(), 1, 1);
        grid1.add(getCarsData(), 2, 1);

        CarsInfo.setStyle("-fx-font-Size: 25px;");
        grid1.setStyle("-fx-background-color: grey;"); // -fx-grid-lines-visible: true

        Scene scene = new Scene(grid1, 1000, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    TableView GetCarsInfo() {
        try {
            // table.setEditable(true);
            table.setPrefSize(480, 400);

            TableColumn carType = new TableColumn("Car Type");
            TableColumn providerComp = new TableColumn("Provider Comp.");
            TableColumn passenger = new TableColumn("Passengers");
            TableColumn price = new TableColumn("Price");
            TableColumn color = new TableColumn("Color");
            TableColumn isAvailable = new TableColumn("Is Available");
            TableColumn status = new TableColumn("Status");
            TableColumn actions = new TableColumn("Actions");


            table.getColumns().addAll(carType, providerComp, passenger, price, color, isAvailable, status, actions);

            carType.setCellValueFactory(new PropertyValueFactory<Car, String>("CarType"));
            providerComp.setCellValueFactory(new PropertyValueFactory<Car, String>("ProviderComp"));
            passenger.setCellValueFactory(new PropertyValueFactory<Car, String>("Passenger"));
            price.setCellValueFactory(new PropertyValueFactory<Car, String>("Price"));
            color.setCellValueFactory(new PropertyValueFactory<Car, String>("Color"));
            isAvailable.setCellValueFactory(new PropertyValueFactory<Car, String>("IsAvailable"));
            status.setCellValueFactory(new PropertyValueFactory<Car, String>("Status"));
            actions.setCellValueFactory(new PropertyValueFactory<Car, Button>("Actions"));


            actions.setCellFactory(
                    new Callback<TableColumn<Car, Boolean>, TableCell<Car, Boolean>>() {

                        @Override
                        public TableCell<Car, Boolean> call(TableColumn<Car, Boolean> p) {
                            return new ButtonCell();
                        }

                    });

            // Generating test data
            // ObservableList<CarTable> carList = FXCollections.observableArrayList();
            CarDaoImpl databaseQuery = new CarDaoImpl();

            List<Car> carlist2 = databaseQuery.getAllCars();
            /*for (int i = 0; i < carlist2.size(); i++) {
                Button btn = new Button("Delete");
                Long id = carlist2.get(i).getId();

                btn.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent args) {
                        deleteCar(id);
                    }
                });

                // carlist2.get(i).setBtn(btn);
            }*/

            ObservableList<Car> oListStavaka = FXCollections.observableArrayList(carlist2); // FXCollections.observableArrayList(databaseQuery.getAllCars());

            table.setItems(oListStavaka);

            return table;

        } catch (Exception ex) {
            System.out.println("Function Name= " + Thread.currentThread().getStackTrace() + ex.getMessage());
            return null;
        }
    }

    GridPane getCarsData() {
        Text addCarText = new Text("Add Car");

        Text carTypeText = new Text("Car Type");
        Text providerCompText = new Text("Provider Comp.");
        Text passengerText = new Text("Passengers");
        Text priceText = new Text("Price");
        Text colorText = new Text("Color");
        Text isAvailableText = new Text("Is Available");
        Text statusText = new Text("Status");

        Button saveBtn = new Button();
        saveBtn.setText("Save");
        saveBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                addCar();
            }
        });

        GridPane grid = new GridPane();
        addCarText.setStyle("-fx-font-size:18px;");
        GridPane.setHalignment(addCarText, HPos.CENTER);

        grid.add(addCarText, 0, 0);
        grid.add(carTypeText, 0, 1);
        grid.add(carTypeTextf, 0, 2);

        grid.add(providerCompText, 0, 3);
        grid.add(providerCompTextf, 0, 4);

        grid.add(passengerText, 0, 5);
        grid.add(passengerTextf, 0, 6);

        grid.add(priceText, 0, 7);
        grid.add(priceTextf, 0, 8);

        grid.add(colorText, 0, 9);
        grid.add(colorTextf, 0, 10);

        grid.add(isAvailableText, 0, 11);
        grid.add(isAvailableTextf, 0, 12);

        grid.add(statusText, 0, 13);
        grid.add(statusTextf, 0, 14);
        grid.add(new Text(""), 0, 15);// just empty space

        grid.add(saveBtn, 0, 16);
        GridPane.setHalignment(saveBtn, HPos.CENTER);
        grid.add(new Text(""), 0, 17);// just empty space

        grid.add(errorText, 0, 18);

        return grid;
    }

    boolean addCar() {
        // 1- Read values from textboxes
        // 2- Save to database
        // 3- Reload Table information

        errorText.setText("");

        String carType = carTypeTextf.getText();
        String providerComp = providerCompTextf.getText();
        Integer passenger = new Integer(passengerTextf.getText());
        Double price = new Double(priceTextf.getText());
        String color = colorTextf.getText();
        Boolean isAvailable = new Boolean(isAvailableTextf.getText());
        String status = statusTextf.getText();

        //
        // validation
        if (carType.equals("") || providerComp.equals("") || passenger.equals("") || price.equals("")
                || color.equals("") || isAvailable.equals("") || status.equals("")) {
            System.out.println("asd" + carType + "asd");
            errorText.setText("Please, Fill all fields first.");
            return false;
        } else {
            CarDaoImpl databaseQuery = new CarDaoImpl();
            Car car = new Car(new Long(0), carType, providerComp, passenger, price, color, isAvailable, status);
            boolean result = databaseQuery.insertCar(car);
            System.out.println(result);

            if (result) {
                ObservableList<Car> carList = FXCollections.observableArrayList();
                carList = table.getItems();
                carList.add(new Car(new Long(0), carType, providerComp, passenger, price, color, isAvailable, status));
                table.setItems(carList);

                emptyTextFields();
                return true;
            } else {
                errorText.setText("System Error,Try again later.");
                return false;
            }

        }
    }

    void emptyTextFields() {
        carTypeTextf.setText("");
        providerCompTextf.setText("");
        passengerTextf.setText("");
        priceTextf.setText("");
        colorTextf.setText("");
        isAvailableTextf.setText("");
        statusTextf.setText("");
    }

    boolean deleteCar(long id) {
        try {
            return deleteCar(id);
        } catch (Exception ex) {
            return false;
        }
    }

    private class ButtonCell extends TableCell<Car, Boolean> {
        final Button cellButton = new Button("Delete");

        ButtonCell() {

            //Action when the button is pressed
            cellButton.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent t) {
                    // get Selected Item
                    Car currentPerson = (Car) ButtonCell.this.getTableView().getItems().get(ButtonCell.this.getIndex());
                    System.out.println("The selected car is" + currentPerson.getCarType());
                }
            });
        }

        //Display button if the row is not empty
        @Override
        protected void updateItem(Boolean t, boolean empty) {
            super.updateItem(t, empty);
            if (!empty) {
                setGraphic(cellButton);
            }
        }
    }

}
