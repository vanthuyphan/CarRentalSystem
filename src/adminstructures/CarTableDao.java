package adminstructures;

import java.util.List;

public interface CarTableDao
{
	boolean insertCar(CarTable car);
	
	boolean deleteCar(long carID);
	
	boolean editCar(CarTable car);
	
	List<CarTable> getAllCars();
}
