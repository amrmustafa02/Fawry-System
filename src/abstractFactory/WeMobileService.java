package abstractFactory;

import java.util.Scanner;


import database.Transaction;

public class WeMobileService implements MobileService {

	@Override
	public void createMobileService(Transaction T) {
		Scanner sc = new Scanner(System.in);
		int amount;
		String number;

		System.out.print("Enter mobile number: ");
		number = sc.next();

		try {
			System.out.print("Enter amount: ");
			amount = sc.nextInt();

			if (number.charAt(0) != '0' && number.charAt(1) != '1' && number.charAt(2) != '5') {
				System.out.println("Wrong number ,please try again");
			} else {
				System.out.println("correct number");
				T.setAmount(amount);
			}

		} catch (Exception e) {
			System.out.println("Error,try again");
		}

	}

}
