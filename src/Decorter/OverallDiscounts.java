package Decorter;

import database.DataBase;
import database.Transaction;

public class OverallDiscounts implements DiscountDecorter {

	@Override
	public Transaction addDiscount(Transaction t) {
		DataBase db = DataBase.getInstance();
		float amount = t.getAmount();
		int dis = db.getOverAllDiscounts();
		amount -= (amount * (dis / 100));
		t.setAmount(amount);
		return t;
	}

}
