package abstractFactory;

import java.util.Scanner;
import java.util.Vector;

import database.Transaction;

public class VodafoneInternetService implements InternetService {

	@Override
	public void createInternetService(Transaction T) {
		Scanner sc = new Scanner(System.in);
		int amount;

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

			T.setAmount(options.get(amount - 1));
			System.out.print("correct choice");

		} catch (Exception e) {
			System.out.println("Error,try again");
		}

	}

}
