package controllers;

import java.util.HashMap;

import database.DataBase;

public class AdminMenuController {
	private DataBase db = DataBase.getInstance();

	public HashMap<String, Integer> getDiscount() {
		return db.getDiscount();
	}

	public void addDiscount(String serviceName, int discount) {
		db.addDiscount(serviceName, discount);
	}
	public void addOverallDiscount(int amount) {
		db.setOverAllDiscounts(amount);
	}

}
