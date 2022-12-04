package Decorter;

import database.Transaction;

public interface DiscountDecorter {

	public Transaction addDiscount(Transaction t);
}
