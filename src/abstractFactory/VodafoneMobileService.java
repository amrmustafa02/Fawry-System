package abstractFactory;

import java.util.Scanner;
import java.util.Vector;

import database.Transaction;

public class VodafoneMobileService implements MobileService {

	@Override
	public void createMobileService(Transaction T) {
		Scanner sc = new Scanner(System.in);
		int amount;
		
		String number;
		System.out.print("Enter mobile number: ");
		number = sc.next();
		
		Vector<Integer> options = new Vector<Integer>();
		options.add(7);
		options.add(10);
		options.add(50);
		options.add(70);
		options.add(100);

		for (int i = 0; i < options.size(); i++)
			System.out.println((i + 1) + "- flex " + options.get(i));

		try {
			System.out.print("Enter choice: ");
			amount = sc.nextInt();

			T.setAmount(options.get(amount - 1));
			System.out.print("correct choice");

		} catch (Exception e) {
			System.out.println("Error,try again");
		}

	}

}
