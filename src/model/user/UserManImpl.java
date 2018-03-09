package model.user;

import db.ConnectionConfiguration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserManImpl implements UserMan {

	private User currentUser;

	@Override
	public void insert(User user) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = ConnectionConfiguration.getConnection();
			preparedStatement = connection.prepareStatement("INSERT INTO user (name, email, password, type, "
					+ "status, created, insurance_company)" + "VALUES (?, ?, ?, ?, ?, sysdate(), ?)");
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setInt(4, user.getType());
			preparedStatement.setInt(5, user.getStatus());
			preparedStatement.setString(6, user.getInsuranceCompany());
			preparedStatement.executeUpdate();
			System.out.println("INSERT INTO car (first_name,last_name)" + "VALUES (?, ?)");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public User selectById(int id) {
		User user = new User();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = ConnectionConfiguration.getConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE user_id = ?");
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				user.setUserId(resultSet.getInt("user_id"));
				user.setName(resultSet.getString("name"));
				user.setEmail(resultSet.getString("email"));
				user.setPassword(resultSet.getString("password"));
				user.setType(resultSet.getInt("type"));
				user.setStatus(resultSet.getInt("status"));
				user.setCreated(resultSet.getDate("created"));
				user.setLastLogin(resultSet.getDate("last_login"));
				user.setInsuranceCompany(resultSet.getString("insurance_company"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return user;
	}

	@Override
	public List<User> selectAll() {
		List<User> users = new ArrayList<User>();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			connection = ConnectionConfiguration.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM user");

			while (resultSet.next()) {
				User user = new User();
				user.setUserId(resultSet.getInt("user_id"));
				user.setName(resultSet.getString("name"));
				user.setEmail(resultSet.getString("email"));
				user.setPassword(resultSet.getString("password"));
				user.setType(resultSet.getInt("type"));
				user.setStatus(resultSet.getInt("status"));
				user.setCreated(resultSet.getDate("created"));
				user.setLastLogin(resultSet.getDate("last_login"));
				user.setInsuranceCompany(resultSet.getString("insurance_company"));

				users.add(user);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return users;
	}

	@Override
	public void delete(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = ConnectionConfiguration.getConnection();
			preparedStatement = connection.prepareStatement("DELETE FROM user WHERE user_id = ?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

			System.out.println("DELETE FROM user WHERE user_id = ?");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void update(User user, int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = ConnectionConfiguration.getConnection();
			preparedStatement = connection
					.prepareStatement("UPDATE user SET " + "name = ?, email = ? WHERE user_id = ?");

			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setInt(3, id);
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public boolean login(String email, String password) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		boolean ret = false;
		try {
			connection = ConnectionConfiguration.getConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE email = ?");
			preparedStatement.setString(1, email);
			resultSet = preparedStatement.executeQuery();
			User user = new User();
			user.setUserId(-1);
			while (resultSet.next()) {
				user.setUserId(resultSet.getInt("user_id"));
				user.setName(resultSet.getString("name"));
				user.setEmail(resultSet.getString("email"));
				user.setPassword(resultSet.getString("password"));
				user.setType(resultSet.getInt("type"));
				user.setStatus(resultSet.getInt("status"));
				user.setCreated(resultSet.getDate("created"));
				user.setLastLogin(resultSet.getDate("last_login"));
				user.setInsuranceCompany(resultSet.getString("insurance_company"));
			}

			if (user.getUserId() != -1) {
				if (user.getStatus() == 0 && user.getPassword().equals(password)) {
					ret = true;
					this.currentUser = user;
					update(user, user.getUserId());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return ret;
	}

	public User getCurrentUser() {
		return currentUser;
	}
}
