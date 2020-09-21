package main.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class Slide12 {
//	public static void main(String[] args) throws SQLException {
//		// Declare Connection, PreparedStatement and ResultSet objects
//		Connection conn = null;
//		PreparedStatement stmt = null;
//		ResultSet rs = null;
//		List<User> allUsers = null;
//		User user = null;
//		
//		try {
//			// Get the database connection
//			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/"
//					+ "jdbctest?user=root&password=root");
//			System.out.println("Connection made!!!");
//			
//			// Set the SQL query string
//			String sql = "SELECT * FROM users";
//			/* Pass the query string to the prepareStatement method of the Connection object and 
//			 * assign the result to the PreparedStatement object. */
//			stmt = conn.prepareStatement(sql);
//		
//			
//			// Run the query and assign the result to the ResultSet object
//			rs = stmt.executeQuery();
//			
//			// Iterate through the ResultSet object as long as there is a next row of data to be read
//			allUsers = new ArrayList<>();
//			while (rs.next()) {
//				user = new User();
//				user.setUserId(rs.getInt(1));
//				user.setName(rs.getString(2));
//				user.setEmail(rs.getString(3));
//				user.setPassword(rs.getString(4));
//				allUsers.add(user);
//			}
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//		}
//		finally
//		{
//			if (!rs.equals(null)) {
//				rs.close();
//			}
//			if (!stmt.equals(null)) {
//				stmt.close();
//			}
//			if (!conn.equals(null)) {
//				conn.close();
//			}
//		}
//		
//		for(User u: allUsers) {
//			System.out.println(u.toString());
//		}
//	}
}