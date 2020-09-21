package JDBC_OOP;

import java.util.List;

public interface UserDAOI {
	enum SQL {
		GET_ALL_USERS("SELECT * FROM users"),
		GET_USERS_BY_ID("SELECT * FROM users WHERE user_id = ?"),
		GET_USERS_BY_NAME("SELECT * FROM users WHERE name = ?"),
		VALIDATE_USER("SELECT * FROM users WHERE email = ? AND password = ?"),
		UPDATE_USER("UPDATE users SET name = ? , password = ? WHERE email = ?");
		
		private final String query;
		
		private SQL(String s) {
			this.query = s;
		}
		
		public String getQuery() {
			return query;
		}
		
		
		
		
	}
	
	/* Queries the database for all user information
	 * @return List containing all user information as User objects */
	List<User> getAllUsers();
	
	/* Queries the database for a specific user's information
	 * User id specifies the user 
	 * @param id refers to the user id being used 
	 * @return User object containing all information relating to the given id*/
	User getUserById(int id);
	
	User getUserByName(String name);
	Boolean validateUser(String email, String password);
	Boolean updateUser(String email, String name, String password);
}
