package controllers;

import java.util.HashMap;
import java.util.Vector;

import database.DataBase;
import database.Transaction;

public class UserMenuController {
	private DataBase db = DataBase.getInstance();

	public float addToWallet(float amount) {
		db.getCurrentUser().addToWallet(amount);
		return db.getCurrentUser().getBalance();
	}
	public HashMap<String, Integer> getDiscounts ( ) {
		return db.getDiscount();
	}

}
