package abstractFactory;

import java.util.Scanner;


import database.Transaction;

public class WeInternetService implements InternetService {

	@Override
	public void createInternetService(Transaction T) {
		Scanner sc = new Scanner(System.in);
		int amount;

		try {
			System.out.print("Enter amount: ");
			amount = sc.nextInt();

			T.setAmount(amount);
			System.out.print("correct amount");

		} catch (Exception e) {
			System.out.println("Error,try again");
		}

	}

}
