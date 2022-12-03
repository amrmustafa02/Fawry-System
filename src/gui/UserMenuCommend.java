package gui;

import java.util.Scanner;

import controllers.SerachController;
import database.DataBase;

public class UserMenuCommend implements ICommend {

	private Scanner sc = new Scanner(System.in);
	private SerachController ctrl = new SerachController();
	private DataBase db = DataBase.getInstance();
	int ch;

	@Override
	public void draw() {
		while (true) {
			System.out.println("\n\n1- Search");
			System.out.println("2- show my transaction");
			System.out.println("3- show my refund requests");
			System.out.println("4- request refund");
			System.out.println("5- add to wallet");
			System.out.println("6- show services ");
			System.out.println("7- Log out\n");
			System.out.print("Enter your choice: ");
			try {
				ch = sc.nextInt();
				if (ch == 1) {
					System.out.print("Enter service name: ");
					// take string matching
					String name = sc.nextLine();
					// search
					ctrl.search(name);

				} else if (ch == 2) {

				} else if (ch == 3) {

				} else if (ch == 4) {

				} else if (ch == 5) {

					System.out.println("Enter amount: ");

					float amount = sc.nextFloat();
					db.getCurrentUser().addToWallet(amount);

					System.out.println("\nwallet: " + db.getCurrentUser().getBalance() + "\n");

				} else if (ch == 6) {

				} else if (ch == 7) {
					break;
				}

			} catch (Exception e) {

			}

		}

	}

}
