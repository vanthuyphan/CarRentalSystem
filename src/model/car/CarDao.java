package model.car;

import java.util.List;

public interface CarDao
{
	boolean insertCar(Car car);
	
	boolean deleteCar(long carID);
	
	boolean editCar(Car car);
	
	List<Car> getAllCars();

	List<Car> search();
}
