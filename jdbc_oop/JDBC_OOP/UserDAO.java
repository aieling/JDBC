package JDBC_OOP;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends AbstractDAO implements UserDAOI {
	
	@Override
	public List<User> getAllUsers() {
		User user = null;
		List<User> listUser = new ArrayList<User>();
		connect();
		try {
			stmt = conn.prepareStatement(SQL.GET_ALL_USERS.getQuery());
			rs = stmt.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setUserId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPassword(rs.getString(4));
				listUser.add(user);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		dispose();
		return listUser;
	}

	@Override
	public User getUserById(int id) {
		User user = null;
		connect();
		try {
			stmt = conn.prepareStatement(SQL.GET_USERS_BY_ID.getQuery());
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setUserId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPassword(rs.getString(4));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		dispose();
		return user;
	}

	@Override
	public User getUserByName(String name) {
		User user = null;
		connect();
		try {
			stmt = conn.prepareStatement(SQL.GET_USERS_BY_NAME.getQuery());
			stmt.setString(1, name);
			rs = stmt.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setUserId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPassword(rs.getString(4));
			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		dispose();

		return user;
	}

	@Override
	public Boolean validateUser(String email, String password) {
		connect();
		try {
			stmt = conn.prepareStatement(SQL.VALIDATE_USER.getQuery());
			stmt.setString(1, email);
			stmt.setString(2, password);
			rs = stmt.executeQuery();
			if (rs.next()) {
				dispose();
				return true;
			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		dispose();
		return false;
	}

	@Override
	public Boolean updateUser(String email, String name, String password) {
		User user = null;
		connect();
		try {
			stmt = conn.prepareStatement(SQL.UPDATE_USER.getQuery());
			stmt.setString(1, name);
			stmt.setString(2, password);
			stmt.setString(3, email);

			rs = stmt.executeQuery();
			int updateInt = stmt.executeUpdate();

			if (updateInt > 0 ){
				dispose();
				return true;
			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		dispose();
		return false;
	}

}
