package view.adminstructures;

public class CarTable {
    long Id;
    String CarType;
    String ProviderComp;
    String Passenger;
    String Price;
    String Color;
    String IsAvailable;
    String Status;

    public CarTable(String carType, String providerComp, String passenger, String price, String color,
                    String isAvailable, String status) {
        //Id = id;
        CarType = carType;
        ProviderComp = providerComp;
        Passenger = passenger;
        Price = price;
        Color = color;
        IsAvailable = isAvailable;
        Status = status;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getCarType() {
        return CarType;
    }

    public void setCarType(String carType) {
        CarType = carType;
    }

    public String getProviderComp() {
        return ProviderComp;
    }

    public void setProviderComp(String providerComp) {
        ProviderComp = providerComp;
    }

    public String getPassenger() {
        return Passenger;
    }

    public void setPassenger(String passenger) {
        Passenger = passenger;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getIsAvailable() {
        return IsAvailable;
    }

    public void setIsAvailable(String isAvailable) {
        IsAvailable = isAvailable;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

}
