package model.car;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.ConnectionConfiguration;

public class CarDaoImpl implements CarDao {

    @Override
    public boolean insertCar(Car car) {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            statement.execute(
                    "INSERT INTO `car_rental_system`.`car`(`CarType`,`ProviderComp`,`Passenger`,`Price`,`Color`,`IsAvailable`,`Status`) VALUES ('"
                            + car.getCarType() + "','" + car.getProvider() + "','" + car.getPassenger() + "','" + car.getPrice() + "','"
                            + car.getColor() + "','" + car.getIsAvailable() + "','" + car.getStatus() + "');");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Override
    public boolean deleteCar(long carID) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean editCar(Car car) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<Car> getAllCars() {
        Connection connection = null;
        Statement statement = null;
        List<Car> carlist = new ArrayList<Car>();

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM car_rental_system.car;");
            if (result != null) {
                while (result.next()) {

                    Long id = result.getLong("id");
                    String carType = result.getString("carType");
                    String provider = result.getString("providerComp");
                    Integer passenger = new Integer(result.getString("passenger"));
                    Double price = new Double(result.getString("price"));
                    String color = result.getString("color");
                    Boolean isAvailable = new Boolean(result.getString("isAvailable"));
                    String status = result.getString("status");
                    carlist.add(new Car(id, carType,
                            provider, passenger, price,
                            color, isAvailable, status));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return carlist;
    }

}
