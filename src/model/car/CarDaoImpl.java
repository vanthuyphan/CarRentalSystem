package model.car;

import java.sql.*;
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

            String sql = "INSERT INTO Car(carType,provider , passengers ,  price ,color , available , status )" +
                    "VALUES ('%s','%s', %d, %d, %s, %d, %s);";
            statement.execute(String.format(sql, car.getCarType(), car.getProvider(), car.getPassenger(), car.getPrice(), car.getColor(),
                    car.getIsAvailable(), car.getStatus())
            );
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

    @Override
    public boolean deleteCar(long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM person WHERE id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();

            System.out.println("DELETE FROM person WHERE id = ?");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
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
        return true;
    }

}
