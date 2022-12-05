package payment;

import database.Transaction;

public class Cash implements IPaymentMethod {

	@Override
	public Transaction Pay(Transaction amount) {
		System.out.println("your transaction will done by cash and initail value is : " + amount.getAmount());
		return amount;

	}

}
