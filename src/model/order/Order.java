package model.order;

/**
 * Created by VanPhan on 3/7/18.
 */
public class Order {

    private int id;
    private String firstName;
    private String lastName;


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

    public Order(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}