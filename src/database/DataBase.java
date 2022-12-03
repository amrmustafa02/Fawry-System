package database;

import java.util.Vector;

// use singleton  
public class DataBase {
	private static DataBase instance = null;
	private Vector<User> users = new Vector<>();

	public static DataBase getInstance() {
		if (instance == null)
			instance = new DataBase();

		return instance;
	}

	public Vector<User> getUsers() {
		return users;
	}

	public void addUser(String userName, String email, String password) {
		users.add(new User(userName, email, password));
	}
}
