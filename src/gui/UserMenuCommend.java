package gui;

import java.util.HashMap;
import java.util.Scanner;

import controllers.UserMenuController;
import database.DataBase;
import database.Transaction;

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
					HashMap<Transaction, String> refundUser = ctrl.getRefundRequest();

					System.out.println(
							"-------------------------------------------------------------------------------------");
					int i = 1;
					for (Transaction t : refundUser.keySet()) {
						System.out.println(i + "refund has id: " + t.getTid() + " its status: " + refundUser.get(t));
					}
					System.out.println(
							"-------------------------------------------------------------------------------------");
				} else if (ch == 3) {
					int tid;
					try {

						System.out.print("Enter id of transaction: ");
						tid = sc.nextInt();
						ctrl.addRefundRequest(tid);

					} catch (Exception e) {
						System.out.println("Error");
					}

				} else if (ch == 4) {

				} else if (ch == 5) {
					System.out.println("Enter amount(put 0 if not you want add any amount) : ");
					float amount = sc.nextFloat();
					System.out.println("\nwallet: " + ctrl.addToWallet(amount) + "\n");

				} else if (ch == 6) {

				} else if (ch == 7) {
					HashMap<String, Integer> discounts = ctrl.getDiscounts();

					int i = 1;
					for (String name : discounts.keySet()) {
						if (discounts.get(name) != 0) {
							System.out.println(i + "- " + name + " = " + discounts.get(name));
							i++;
						}
					}
				} else if (ch == 8) {
					break;
				}

			} catch (Exception e) {

			}

		}

	}

}
