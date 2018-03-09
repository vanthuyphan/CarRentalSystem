package model.adminRequests;

import db.ConnectionConfiguration;
import model.order.Order;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RequestsImpl implements iRequests {

    @Override
    public List<Order> selectAllApproved() {
        Connection connection = null;
        Statement preparedStatement = null;
        List<Order> ordersList = new ArrayList<Order>();
        try {
            connection = ConnectionConfiguration.getConnection();
            ResultSet result = preparedStatement.executeQuery("SELECT Orders.id,car.CarType,orders.status,User.email FROM Orders Join car on car.id=orders.id"
                    + " join user on user.user_id=orders.user where orders.status='approved'");
            if (result != null) {
                while (result.next()) {

                    int id = result.getInt("id");
                    String status = result.getString("status");
                    String car_type = result.getString("CarType");
                    String customerName = result.getString("user") ;

                    ordersList.add(new Order (status,id,customerName,car_type));
                }
            }

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

        return ordersList;    }

    @Override
    public List<Order> selectAllOrders() {
        Connection connection = null;
        Statement preparedStatement = null;
        List<Order> ordersList = new ArrayList<Order>();

        try {
            connection = ConnectionConfiguration.getConnection();
            ResultSet result = preparedStatement.executeQuery("SELECT Orders.id,car.CarType,orders.status,User.email FROM Orders Join car on car.id=orders.id"
                   + " join user on user.user_id=orders.user");
            if (result != null) {
                while (result.next()) {

                    int id = result.getInt("id");
                    String status = result.getString("status");
                    String car_type = result.getString("CarType");
                    String customerName = result.getString("user") ;

                    ordersList.add(new Order (status,id,customerName,car_type));
                }
            }

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
        return ordersList;
    }
}
