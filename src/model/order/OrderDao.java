package model.order;

import model.car.Car;

import java.util.List;

/**
 *  Created by VanPhan on 3/7/18.
 */
public interface OrderDao {

    void createPersonTable();

    void insert(Car car);

    Car selectById(int id);

    List<Car> selectAll();

    void delete(int id);

    void update(Car car, int id);
}
