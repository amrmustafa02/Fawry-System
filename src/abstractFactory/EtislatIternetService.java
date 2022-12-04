package abstractFactory;

import java.util.Scanner;

import database.Transaction;

public class EtislatIternetService implements InternetService {

	@Override
	public void createInternetService(Transaction T) {
		Scanner sc = new Scanner(System.in);
		float amount;

		System.out.print("Enter amount: ");
		amount = sc.nextInt();

		if (amount <= 200) {
			System.out.print("accepted amount");
			T.setAmount(amount);
		}

	}

}
