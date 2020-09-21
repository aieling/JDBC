package JDBC_OOP;

import java.util.List;

public class UserApp {
	public static void main(String[] args) {
		UserDAO udao = new UserDAO();
		User uById = udao.getUserById(1);
		
		List<User> list = udao.getAllUsers();
		System.out.println(list);
		
		User user = udao.getUserByName("John");
		System.out.println(user);
		
		Boolean update = udao.updateUser("helenekev@gmail.com", "test", "new");
		System.out.println(update);
		
		Boolean validate = udao.validateUser("helenekev@gmail.com", "new");
		System.out.println(validate);
	}
}
