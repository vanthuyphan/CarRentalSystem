package model.car;

import db.ConnectionConfiguration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 3/7/18.
 */
public class CarDaoImpl implements CarDao
{

	/** Creates table named Car with three columns (id, first_name, last_name) **/
	@Override
	public void createPersonTable()
	{
		Connection connection = null;
		Statement statement = null;

		try
		{
			connection = ConnectionConfiguration.getConnection();
			statement = connection.createStatement();
			statement.execute("CREATE TABLE IF NOT EXISTS person (id int primary key unique auto_increment,"
					+ "first_name varchar(55), last_name varchar(55))");

		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
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

	/** Inserts new record in Car table as you pass new Car instance **/
	@Override
	public void insert(Car car)
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try
		{
			connection = ConnectionConfiguration.getConnection();
			preparedStatement = connection
					.prepareStatement("INSERT INTO person (first_name,last_name)" + "VALUES (?, ?)");
			preparedStatement.setString(1, car.getFirstName());
			preparedStatement.setString(2, car.getLastName());
			preparedStatement.executeUpdate();
			System.out.println("INSERT INTO car (first_name,last_name)" + "VALUES (?, ?)");

		}
		catch (Exception e)
		{
			e.printStackTrace();
		} 
		finally
		{
			if (preparedStatement != null)
			{
				try
				{
					preparedStatement.close();
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
	public Car selectById(int id)
	{
		Car car = new Car();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try
		{
			connection = ConnectionConfiguration.getConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM person WHERE id = ?");
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next())
			{
				car.setId(resultSet.getInt("id"));
				car.setFirstName(resultSet.getString("first_name"));
				car.setLastName(resultSet.getString("last_name"));
			}

		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			if (resultSet != null)
			{
				try
				{
					resultSet.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			if (preparedStatement != null)
			{
				try
				{
					preparedStatement.close();
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

		return car;
	}

	@Override
	public List<Car> selectAll()
	{
		List<Car> cars = new ArrayList<Car>();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try
		{
			connection = ConnectionConfiguration.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM person");

			while (resultSet.next())
			{
				Car car = new Car();
				car.setId(resultSet.getInt("id"));
				car.setFirstName(resultSet.getString("first_name"));
				car.setLastName(resultSet.getString("last_name"));

				cars.add(car);
			}

		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			if (resultSet != null)
			{
				try
				{
					resultSet.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
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

		return cars;
	}

	@Override
	public void delete(int id)
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try
		{
			connection = ConnectionConfiguration.getConnection();
			preparedStatement = connection.prepareStatement("DELETE FROM person WHERE id = ?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

			System.out.println("DELETE FROM person WHERE id = ?");

		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			if (preparedStatement != null)
			{
				try
				{
					preparedStatement.close();
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
	public void update(Car car, int id)
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try
		{
			connection = ConnectionConfiguration.getConnection();
			preparedStatement = connection
					.prepareStatement("UPDATE person SET " + "first_name = ?, last_name = ? WHERE id = ?");

			preparedStatement.setString(1, car.getFirstName());
			preparedStatement.setString(2, car.getLastName());
			preparedStatement.setInt(3, id);
			preparedStatement.executeUpdate();

			System.out.println("UPDATE car SET " + "first_name = ?, last_name = ? WHERE id = ?");

		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			if (preparedStatement != null)
			{
				try
				{
					preparedStatement.close();
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
}
