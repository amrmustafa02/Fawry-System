package abstractFactory;

import java.util.Scanner;
import java.util.Vector;

import database.Transaction;

public class OrangeMobileService implements MobileService {

	@Override
	public void createMobileService(Transaction T) {

		Scanner sc = new Scanner(System.in);
		int amount;
		String number;

		System.out.print("Enter mobile number: ");
		number = sc.next();

		Vector<Integer> options = new Vector<Integer>();
		options.add(10);
		options.add(20);
		options.add(50);
		options.add(70);
		options.add(100);
		options.add(150);

		for (int i = 0; i < options.size(); i++)
			System.out.println((i + 1) + "- orange internet " + options.get(i));
		try {
			System.out.print("Enter choice: ");
			amount = sc.nextInt();

			if (number.charAt(0) != '0' && number.charAt(1) != '1' && number.charAt(2) != '2') {
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
