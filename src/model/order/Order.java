package model.order;

import model.car.Car;
import model.user.User;

/**
 * Created by VanPhan on 3/7/18.
 */
public class Order {

    private int id;
    private Car car;
    private User user;


    // 2nd constructor by Hazem
    private String status ;
    private String car_type ;
    private String customerName ;

    public Order(String status, int id, String customerName,String car_type) {
    this.status = status ;
    this.id = id ;
    this.customerName = customerName ;
    this.car_type = car_type ;
    }

    public Order(Car car, User user) {
        this.car = car;
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}