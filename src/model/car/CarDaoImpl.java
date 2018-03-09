package model.car;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
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
                    "VALUES ('%s','%s', %f, %f, %s, %s, %s);";
            String formattedString = String.format(sql,
                    car.getCarType(), car.getProvider(), car.getPassenger().doubleValue(),
                    car.getPrice().doubleValue(), car.getColor(),
                    car.getIsAvailable(), car.getStatus());
            statement.execute(formattedString);
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
                    String provider = result.getString("provider");
                    Integer passenger = new Integer(result.getString("passengers"));
                    Double price = new Double(result.getString("price"));
                    String color = result.getString("color");
                    Boolean isAvailable = new Boolean(result.getString("available"));
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

    @Override
    public List<Car> search() {
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
                    String provider = result.getString("provider");
                    Integer passenger = new Integer(result.getString("passengers"));
                    Double price = new Double(result.getString("price"));
                    String color = result.getString("color");
                    Boolean isAvailable = new Boolean(result.getString("available"));
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

    public List<Car> search(String pickUpDate, String dropOffDate, String provider, String passengers) {
        return null;

    }
}
