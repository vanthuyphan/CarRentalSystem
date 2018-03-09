package db;

import java.sql.*;
import java.util.ResourceBundle;

import javax.sql.DataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class ConnectionConfiguration
{
	public static final String URL = "jdbc:mysql://localhost:3306/car_rental_system?user=root&password=123456&useSSL=false";
	/**
	 * In my case username is "root" *
	 */
	public static final String USERNAME = "root";
	/**
	 * In my case password is "1234" *
	 */
	public static final String PASSWORD = "123456";

	public static Connection getConnection()
	{
		Connection connection = null;

		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL);
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return connection;
	}

}