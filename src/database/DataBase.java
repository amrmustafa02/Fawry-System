package database;

import java.security.Provider.Service;
import java.util.HashMap;
import java.util.Vector;

// use singleton  
public class DataBase {
	private static DataBase instance = null;
	private Vector<User> users = new Vector<>();
	private HashMap<String, Service> services = new HashMap<String, Service>();
	private static HashMap<String, Integer> discounts = new HashMap<String, Integer>();
	private int overAllDiscounts;
	private User currentUser = null;

	public static DataBase getInstance() {

		if (instance == null) {
			instance = new DataBase();
			discounts.put("Mobile recharge", 0);
			discounts.put("internet recharge", 0);
			discounts.put("Landline", 0);
			discounts.put("Donations ", 0);

		}

		return instance;
	}

	public Vector<User> getUsers() {
		return users;
	}

	public void addUser(String userName, String email, String password) {
		users.add(new User(userName, email, password));
	}

	public HashMap<String, Service> getServices() {
		return services;
	}

	public Integer getDiscount(String service) {
		return discounts.get(service);
	}

	public void addDiscounts(String service, Integer discount) {
		discounts.replace(service, discount);
	}

	public int getOverAllDiscounts() {
		return overAllDiscounts;
	}

	public void setOverAllDiscounts(int overAllDiscounts) {
		this.overAllDiscounts = overAllDiscounts;
	}

	public void setCurrentUser(User user) {
		this.currentUser = user;
	}

	public User getCurrentUser() {
		return this.currentUser;
	}
}
