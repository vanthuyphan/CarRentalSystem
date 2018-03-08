package adminstructures;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.ConnectionConfiguration;

public class CarTableDaoImplimentation implements CarTableDao
{

	@Override
	public boolean insertCar(CarTable car)
	{
		Connection connection = null;
		Statement statement = null;

		try
		{
			connection = ConnectionConfiguration.getConnection();
			statement = connection.createStatement();
			statement.execute(
					"INSERT INTO `car_rental_system`.`car`(`CarType`,`ProviderComp`,`Passenger`,`Price`,`Color`,`IsAvailable`,`Status`) VALUES ('"
							+ car.CarType + "','" + car.ProviderComp + "','" + car.Passenger + "','" + car.Price + "','"
							+ car.Color + "','" + car.IsAvailable + "','" + car.Status + "');");
			return true;
		} catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}

		finally
		{
			if (statement != null)
			{
				try
				{
					statement.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			}

			if (connection != null)
			{
				try
				{
					connection.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public boolean deleteCar(long carID)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editCar(CarTable car)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<CarTable> getAllCars()
	{
		Connection connection = null;
		Statement statement = null;
		List<CarTable> carlist = new ArrayList<CarTable>();

		try
		{
			connection = ConnectionConfiguration.getConnection();
			statement = connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM car_rental_system.car;");
			if (result != null)
			{
				while (result.next())
				{
					carlist.add(new CarTable(result.getLong("id"), result.getString("carType"),
							result.getString("providerComp"), result.getString("passenger"), result.getString("price"),
							result.getString("color"), result.getString("isAvailable"), result.getString("status")));
				}
			}

		} catch (Exception e)
		{
			e.printStackTrace();
		}

		finally
		{
			if (statement != null)
			{
				try
				{
					statement.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			}

			if (connection != null)
			{
				try
				{
					connection.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		return carlist;
	}

}
