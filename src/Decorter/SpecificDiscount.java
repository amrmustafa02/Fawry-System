package Decorter;

import java.util.HashMap;

import database.DataBase;
import database.Transaction;
import payment.IPaymentMethod;

public class SpecificDiscount extends DiscountDecorter {

	public SpecificDiscount(IPaymentMethod method) {
		super(method);

	}

	@Override
	public float addDiscount(Transaction t) {
		DataBase db = DataBase.getInstance();
		String service = t.getService();

		HashMap<String, Integer> serviceDisName = db.getDiscount();
		int dis = serviceDisName.get(service);
		float amount = t.getAmount();

		amount -= (amount * (dis / 100.0));

		return amount;
	}

	public Transaction Pay(Transaction amount) {
		float newAmount = addDiscount(amount);
		amount.setAmount(newAmount);
		System.out.println("apply Specific Discount");
		return amount;
	}

}
