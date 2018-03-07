package model.car;

import model.car.Car;

import java.util.List;

/**
 * Created by admin on 3/7/18.
 */
public interface CarDao {

    void createPersonTable();

    void insert(Car car);

    Car selectById(int id);

    List<Car> selectAll();

    void delete(int id);

    void update(Car car, int id);
}
