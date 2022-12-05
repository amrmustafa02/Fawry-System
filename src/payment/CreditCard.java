package payment;

import java.util.Scanner;

import database.Transaction;

public class CreditCard implements IPaymentMethod {

	@Override
	public Transaction Pay(Transaction amount) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter credit card: ");
		String cardNumber = sc.next();
		System.out
				.println("your transaction will done by credit card " + cardNumber + " and initail value is : " + amount.getAmount());
		return amount;
	}

}
