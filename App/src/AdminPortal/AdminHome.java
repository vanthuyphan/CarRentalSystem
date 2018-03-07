package AdminPortal;

//import java.awt.Button;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import AdminStructures.CarTable;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AdminHome extends Application
{
	final TableView table = new TableView();

	TextField carTypeTextf = new TextField();
	TextField providerCompTextf = new TextField();
	TextField passengerTextf = new TextField();
	TextField priceTextf = new TextField();
	TextField colorTextf = new TextField();
	TextField isAvailableTextf = new TextField();
	TextField statusTextf = new TextField();

	Text errorText = new Text();

	public static void main(String[] args)
	{
		// launch(args);
		Application.launch(AdminHome.class, args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		Parent root = FXMLLoader.load(getClass().getResource("AdminHome.fxml"));
		primaryStage.setTitle("Admin Portal (Car Rental System)");

		Text CarsInfo = new Text(" Cars Information:-");

		GridPane grid1 = new GridPane();
		grid1.setHgap(10);
		grid1.add(CarsInfo, 0, 0);
		grid1.add(GetCarsInfo(), 1, 1);
		grid1.add(generateAddingGrid(), 2, 1);

		CarsInfo.setStyle("-fx-font-Size: 25px;");
		grid1.setStyle("-fx-background-color: grey;"); // -fx-grid-lines-visible: true

		Scene scene = new Scene(grid1, 1000, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	TableView GetCarsInfo()
	{
		try
		{

			// table.setEditable(true);
			table.setPrefSize(480, 400);

			TableColumn carType = new TableColumn("Car Type");
			TableColumn providerComp = new TableColumn("Provider Comp.");
			TableColumn passenger = new TableColumn("Passengers");
			TableColumn price = new TableColumn("Price");
			TableColumn color = new TableColumn("Color");
			TableColumn isAvailable = new TableColumn("Is Available");
			TableColumn status = new TableColumn("Status");

			table.getColumns().addAll(carType, providerComp, passenger, price, color, isAvailable, status);

			carType.setCellValueFactory(new PropertyValueFactory<CarTable, String>("CarType"));
			providerComp.setCellValueFactory(new PropertyValueFactory<CarTable, String>("ProviderComp"));
			passenger.setCellValueFactory(new PropertyValueFactory<CarTable, String>("Passenger"));
			price.setCellValueFactory(new PropertyValueFactory<CarTable, String>("Price"));
			color.setCellValueFactory(new PropertyValueFactory<CarTable, String>("Color"));
			isAvailable.setCellValueFactory(new PropertyValueFactory<CarTable, String>("IsAvailable"));
			status.setCellValueFactory(new PropertyValueFactory<CarTable, String>("Status"));

			// Generating test data
			ObservableList<CarTable> carList = FXCollections.observableArrayList();
			carList.add(new CarTable("Van", "BMW", "10", "1000", "Green", "yes", "Ready"));
			carList.add(new CarTable("Sedan", "BMW", "10", "1000", "Green", "no", "Ready"));
			carList.add(new CarTable("Van", "BMW", "10", "1000", "Green", "yes", "Ready"));
			carList.add(new CarTable("Truck", "VOLOVO", "15", "1000", "Green", "No", "Ready"));
			carList.add(new CarTable("Van", "BMW", "10", "1000", "Red", "yes", "Ready"));
			carList.add(new CarTable("Van", "Mercedes", "10", "1000", "Green", "yes", "Ready"));
			carList.add(new CarTable("Van", "BMW", "10", "1000", "Green", "No", "Ready"));

			table.setItems(carList);

			return table;

		} catch (Exception ex)
		{
			System.out.println("Function Name= " + Thread.currentThread().getStackTrace() + ex.getMessage());
			return null;
		}
	}

	GridPane generateAddingGrid()
	{
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
			public void handle(ActionEvent arg0)
			{
				// 1- Read values from textboxes
				// 2- Save to database
				// 3- Reload Table information
				
				errorText.setText("");
				
				String carType = carTypeTextf.getText();
				String providerComp = providerCompTextf.getText();
				String passenger = passengerTextf.getText();
				String price = priceTextf.getText();
				String color = colorTextf.getText();
				String isAvailable = isAvailableTextf.getText();
				String status = statusTextf.getText();

				//
				// validation
				if (carType.equals("") || providerComp.equals("") || passenger.equals("") || price.equals("")
						|| color.equals("") || isAvailable.equals("") || status.equals(""))
				{
					System.out.println("asd" + carType + "asd");
					errorText.setText("Please, Fill all fields first.");
					return;
				} else
				{

					ObservableList<CarTable> carList = FXCollections.observableArrayList();
					// carList.add();

					carList = table.getItems();
					carList.add(new CarTable(carType, providerComp, passenger, price, color, isAvailable, status));
					table.setItems(carList);

					emptyTextFields();
				}
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

		// GridPane grid = new GridPane();
		// grid.add(CarTypeText, 0, 0);
		// grid.add(CarTypeTextf, 0, 1);
		//
		// grid.add(ProviderCompText, 1, 0);
		// grid.add(ProviderCompTextf, 1, 1);
		//
		// grid.add(PassengerText, 2, 0);
		// grid.add(PassengerTextf, 2, 1);
		//
		// grid.add(PriceText, 3, 0);
		// grid.add(PriceTextf, 3, 1);
		//
		// grid.add(ColorText, 4, 0);
		// grid.add(ColorTextf, 4, 1);
		//
		// grid.add(IsAvailableText, 5, 0);
		// grid.add(IsAvailableTextf, 5, 1);
		//
		// grid.add(StatusText, 6, 0);
		// grid.add(StatusTextf, 6, 1);
	}

	void emptyTextFields()
	{
		carTypeTextf.setText("");
		providerCompTextf.setText("");
		passengerTextf.setText("");
		priceTextf.setText("");
		colorTextf.setText("");
		isAvailableTextf.setText("");
		statusTextf.setText("");
	}

}
