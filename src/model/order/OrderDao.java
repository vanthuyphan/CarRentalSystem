package model.order;

import model.car.Car;
import model.user.User;

import java.util.List;

/**
 *  Created by VanPhan on 3/7/18.
 */
public interface OrderDao {
    void createOrder(Car car, User user);

    Car selectById(int id);

    List<Order> selectAll();
}
