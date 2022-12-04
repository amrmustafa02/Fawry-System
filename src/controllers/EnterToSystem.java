package controllers;

import java.util.Vector;

import database.DataBase;
import database.User;

public class EnterToSystem {

	private DataBase db = DataBase.getInstance();

	public Boolean signUp(String userName, String email, String password) {
		// get users from database
		Vector<User> users = db.getUsers();

		for (int i = 0; i < users.size(); i++) {
			if (email.equals(users.get(i).getEmail())) {
				return false;
			}
		}

		db.addUser(userName, email, password);
		return true;

	}

	public Boolean signIn(String email, String password) {
		// get users from database
		Vector<User> users = db.getUsers();

		// check on user
		for (int i = 0; i < users.size(); i++) {
			if (email.equals(users.get(i).getEmail())) {
				if (password.equals(users.get(i).getPassword())) {
					db.setCurrentUser(users.get(i));
					return true;
				}
			}
		}
		return false;

	}
}
