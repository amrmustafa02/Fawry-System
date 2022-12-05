package payment;

import database.Transaction;

public interface IPaymentMethod {
	public Transaction Pay(Transaction amount );

}
