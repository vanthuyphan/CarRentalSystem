package model.car;

public class Car {
    private Long id;
    private String carType;
    private String provider;
    private Integer passenger;
    private Double price;
    private String color;
    private Boolean isAvailable;
    private String status;

    public Car(Long Id, String carType, String provider, Integer passenger, Double price, String color,
               Boolean isAvailable, String status) {
        // Id = id;
        this.carType = carType;
        this.provider = provider;
        this.passenger = passenger;
        this.price = price;
        this.color = color;
        this.isAvailable = isAvailable;
        this.status = status;
        this.id = Id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        id = id;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public Integer getPassenger() {
        return passenger;
    }

    public void setPassenger(Integer passenger) {
        this.passenger = passenger;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
