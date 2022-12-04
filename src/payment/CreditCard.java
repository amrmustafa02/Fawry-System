package payment;

import java.util.Scanner;

public class CreditCard implements IPaymentMethod {

	@Override
	public Boolean Pay(int amount) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter credit card: ");
		String cardNumber = sc.next();
		return true;
	}

}
