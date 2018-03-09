package model.order;

import db.ConnectionConfiguration;
import model.car.Car;
import model.user.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class OrderDaoImpl implements OrderDao {

    @Override
    public void createOrder(Car car, User user) {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();

            String sql = "INSERT INTO `Order`(car, user , status )" +
                    "VALUES ('%d','%d', 'Waiting');";
            String formattedString = String.format(sql,
                    car.getId(), user.getUserId());
            statement.execute(formattedString);
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
    }

    @Override
    public Car selectById(int id) {
        return null;
    }

    @Override
    public List<Order> selectAll() {
        return null;
    }
}
