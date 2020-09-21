package main.java.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Slide16 {
	int id;
	String email, name, password;
	
	public static void main(String[] args) throws SQLException  {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/"
					+ "jdbctest?user=root&password=root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Slide16 users = new Slide16();	
		//users.getAllUsers(conn);
		users.getUsersByName(conn, "John");
		Boolean result = users.validateUser(conn, "john@doe.com", "john1234");
		System.out.println(result);
		
		System.out.println("Update: "+users.updateUser(conn, "john@doe.com", "updatedname", "helloUpdate"));
	}

	public void getAllUsers(Connection conn) throws SQLException{
	Statement stmt = null;
	ResultSet rs = null;
		try {
			String sql = "SELECT * FROM users";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println("Id: "+rs.getInt(1));
				System.out.println("Email: "+rs.getString(2));
				System.out.println("Name: "+rs.getString(3));
				System.out.println("Password: "+rs.getString(4));
				System.out.println("--------------------------");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs.equals(null)) {
				rs.close();
			}
			if(!stmt.equals(null)) {
				stmt.close();
			}
			if(!conn.equals(null)) {
				conn.close();
			}
		}
	}
	
	public void getUsersByName(Connection conn, String name) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM users where name=?";
		
		stmt = conn.prepareStatement(sql);
		stmt.setString(1,name);
		rs = stmt.executeQuery();
		
		if(rs.next()) {
			toString(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getNString(4) );
		}	
	}
	
	public Boolean validateUser(Connection conn, String email, String password) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM users where email = ? AND password = ?";
		
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, email);
		stmt.setString(2, password);
		rs = stmt.executeQuery();
		
		if(rs.next()) {
			return true;
		}
		return false;
	}
	
	public Boolean updateUser(Connection conn, String email, String name, String password) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "UPDATE users SET name = ?, password = ? WHERE email = ?";
		
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, name);
		stmt.setString(2, password);
		stmt.setString(3, email);
		
		stmt.executeQuery();
		
		if(stmt.executeUpdate() > 0) {
			return true;
		}
		
		
		return false;
	}
	
	
	
	public static void toString(int id, String email, String name, String password) {
		System.out.println(
				"Id "+id+"\n"
				+"email: "+email+"\n"
				+"name: "+name+"\n"
				+"password: "+password+"\n"
				+"----------------------"+"\n"
				);
		
	}

	
	
	
	
}
