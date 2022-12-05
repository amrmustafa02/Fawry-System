package Decorter;

import database.DataBase;
import database.Transaction;
import payment.IPaymentMethod;

public class OverallDiscounts extends DiscountDecorter {

	public OverallDiscounts(IPaymentMethod p) {
		super(p);
	}

	@Override
	public float addDiscount(Transaction t) {
		DataBase db = DataBase.getInstance();
		float amount = t.getAmount();
		int dis = db.getOverAllDiscounts();
		amount -= (amount * (dis / 100.0));
		return amount;
	}

	public Transaction Pay(Transaction amount) {
		float newAmount = addDiscount(amount);
		amount.setAmount(newAmount);
		System.out.println("apply Overall discount");
		return amount;
	}

}
