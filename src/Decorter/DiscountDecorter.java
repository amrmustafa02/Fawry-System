package Decorter;

import database.Transaction;
import payment.IPaymentMethod;

public abstract class DiscountDecorter implements IPaymentMethod {
	private IPaymentMethod method;

	public abstract float addDiscount(Transaction t);

	public  DiscountDecorter(IPaymentMethod method) {
		this.method = method;
	}

	@Override
	public Transaction Pay(Transaction amount) {
		
		
		return method.Pay(amount);
	}

}
