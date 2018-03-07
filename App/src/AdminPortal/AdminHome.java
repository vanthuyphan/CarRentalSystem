package AdminPortal;

import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import AdminStructures.CarTable;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdminHome extends Application
{
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

		// VBox vbox = new VBox();
		// vbox.setSpacing(5);
		// vbox.setPadding(new Insets(10, 0, 0, 10));
		// vbox.getChildren().addAll("Cars Info", GetCarsInfo());

		Scene scene = new Scene(GetCarsInfo(), 1000, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	TableView GetCarsInfo()
	{
		try
		{
			TableView Table = new TableView();
			Table.setEditable(true);

			TableColumn CarType = new TableColumn("Car Type");
			TableColumn ProviderComp = new TableColumn("Provider Comp.");
			TableColumn Passenger = new TableColumn("Passengers");
			TableColumn Price = new TableColumn("Price");
			TableColumn Color = new TableColumn("Color");
			TableColumn IsAvailable = new TableColumn("Is Available");
			TableColumn Status = new TableColumn("Status");

			Table.getColumns().addAll(CarType, ProviderComp, Passenger, Price, Color, IsAvailable, Status);

			CarType.setCellValueFactory(new PropertyValueFactory<CarTable, String>("CarType"));
			ProviderComp.setCellValueFactory(new PropertyValueFactory<CarTable, String>("ProviderComp"));
			Passenger.setCellValueFactory(new PropertyValueFactory<CarTable, String>("Passenger"));
			Price.setCellValueFactory(new PropertyValueFactory<CarTable, String>("Price"));
			Color.setCellValueFactory(new PropertyValueFactory<CarTable, String>("Color"));
			IsAvailable.setCellValueFactory(new PropertyValueFactory<CarTable, String>("IsAvailable"));
			Status.setCellValueFactory(new PropertyValueFactory<CarTable, String>("Status"));

			// Generating test data
			ObservableList<CarTable> CarList = FXCollections.observableArrayList();
			CarList.add(new CarTable("Van", "BMW", "10", "1000", "Green", "yes", "Ready"));
			CarList.add(new CarTable("Sedan", "BMW", "10", "1000", "Green", "no", "Ready"));
			CarList.add(new CarTable("Van", "BMW", "10", "1000", "Green", "yes", "Ready"));
			CarList.add(new CarTable("Truck", "VOLOVO", "15", "1000", "Green", "No", "Ready"));
			CarList.add(new CarTable("Van", "BMW", "10", "1000", "Red", "yes", "Ready"));
			CarList.add(new CarTable("Van", "Mercedes", "10", "1000", "Green", "yes", "Ready"));
			CarList.add(new CarTable("Van", "BMW", "10", "1000", "Green", "No", "Ready"));

			Table.setItems(CarList);

			return Table;

		} catch (Exception ex)
		{
			System.out.println("Function Name= " + Thread.currentThread().getStackTrace() + ex.getMessage());
			return null;
		}
	}

}
