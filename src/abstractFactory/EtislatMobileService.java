package abstractFactory;

import java.util.Scanner;

import database.Transaction;

public class EtislatMobileService implements MobileService {

	@Override
	public void createMobileService(Transaction T) {
		Scanner sc = new Scanner(System.in);
		float amount;
		String number;

		System.out.print("Enter mobile number: ");
		number = sc.next();

		System.out.print("Enter amount: ");
		amount = sc.nextInt();

		if (number.charAt(0) != '0' && number.charAt(1) != '1' && number.charAt(2) != '1') {
			System.out.println("Wrong number ,please try again");
		} else {
			System.out.println("correct number");
			T.setAmount(amount);
		}

	}

}
