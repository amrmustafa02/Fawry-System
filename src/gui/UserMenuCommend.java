package gui;

import java.util.Scanner;

import controllers.UserMenuController;
import database.DataBase;

public class UserMenuCommend implements ICommend {

	private Scanner sc = new Scanner(System.in);
	private UserMenuController ctrl = new UserMenuController();
	private DataBase db = DataBase.getInstance();

	@Override
	public void draw() {
		int ch;
		while (true) {
			System.out.println("\n\n1- Search");
			System.out.println("3- show my refund requests");
			System.out.println("4- request refund");
			System.out.println("5- add to wallet");
			System.out.println("6- show services ");
			System.out.println("7- show discounts ");
			System.out.println("8- Log out\n");
			System.out.print("Enter your choice: ");
			try {
				ch = sc.nextInt();
				if (ch == 1) {
					System.out.print("Enter service name: ");
					// take string matching
					String name = sc.nextLine();
					// search

				} else if (ch == 2) {

				} else if (ch == 3) {

				} else if (ch == 4) {

				} else if (ch == 5) {
					System.out.println("Enter amount(put 0 if not you want add any amount) : ");
					float amount = sc.nextFloat();
					System.out.println("\nwallet: " + ctrl.addToWallet(amount) + "\n");

				} else if (ch == 6) {

				} else if (ch == 7) {

				} else if (ch == 8) {
					
					break;
				}

			} catch (Exception e) {

			}

		}

	}

}
