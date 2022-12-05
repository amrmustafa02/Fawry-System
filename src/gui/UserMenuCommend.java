package gui;

import java.util.HashMap;
import java.util.Scanner;

import Decorter.DiscountDecorter;
import Decorter.OverallDiscounts;
import Decorter.SpecificDiscount;
import abstractFactory.MobileService;
import abstractFactory.ServiceProviderFactory;
import abstractFactory.WeFactory;
import controllers.UserMenuController;
import database.DataBase;
import database.Transaction;
import payment.Cash;
import payment.CreditCard;
import payment.IPaymentMethod;
import payment.Wallet;

public class UserMenuCommend implements ICommend {

	private Scanner sc = new Scanner(System.in);
	private UserMenuController ctrl = new UserMenuController();
	private DataBase db = DataBase.getInstance();

	@Override
	public void draw() {
		int ch;
		while (true) {
			System.out.println("\n\n1- Search");
			System.out.println("2- show my refund requests");
			System.out.println("3- request refund");
			System.out.println("4- add to wallet");
			System.out.println("5- show services ");
			System.out.println("6- show discounts ");
			System.out.println("7- Log out\n");
			System.out.print("Enter your choice: ");
			try {
				ch = sc.nextInt();
				// ------------------------ 1
				// -----------------------------------------------------------------------
				if (ch == 1) {
					System.out.print("Enter service name: ");
					// take string matching
					String name = sc.nextLine();
					// search

				}
				// ------------------------ 2
				// -----------------------------------------------------------------------

				else if (ch == 2) {
					HashMap<Transaction, String> refundUser = ctrl.getRefundRequest();

					System.out.println(
							"-------------------------------------------------------------------------------------");
					int i = 1;
					for (Transaction t : refundUser.keySet()) {
						System.out.println(i + "refund has id: " + t.getTid() + " its status: " + refundUser.get(t));
					}
					System.out.println(
							"-------------------------------------------------------------------------------------");
				}
				// ------------------------ 3
				// -----------------------------------------------------------------------

				else if (ch == 3) {
					int tid;
					try {

						System.out.print("Enter id of transaction: ");
						tid = sc.nextInt();
						ctrl.addRefundRequest(tid);
						System.out.print("refund request send to admin");

					} catch (Exception e) {
						System.out.println("Error");
					}

				}
				// ------------------------ 4
				// -----------------------------------------------------------------------

				else if (ch == 4) {
					System.out.println("Enter amount(put 0 if not you want add any amount) : ");
					float amount = sc.nextFloat();
					System.out.println("\nwallet: " + ctrl.addToWallet(amount) + "\n");

				}
				// ------------------------ 5
				// -----------------------------------------------------------------------

				else if (ch == 5) {
					Transaction t = new Transaction();
					ServiceProviderFactory factory;
					Scanner sc = new Scanner(System.in);
					System.out.println("--------------------------------------");
					System.out.println("1- mobile service");
					System.out.println("2- Internet service");
					System.out.println("3- Landline ");
					System.out.println("4- Donations ");
					System.out.println("--------------------------------------");
					System.out.print("Enter choice: ");
					int cs = sc.nextInt();

					if (cs == 1) {
						System.out.println("1- WE");
						System.out.println("2- etislat");
						System.out.println("3- vodafone");
						System.out.println("4- we");
						System.out.print("Enter: ");
						int cs2 = sc.nextInt();
						if (cs2 == 1) {
							t.setService("Mobile recharge");
							factory = new WeFactory();
							MobileService service = factory.createMobileService(1);
							service.createMobileService(t);

						}

					} else if (cs == 2) {

					}
					IPaymentMethod payment;

					System.out.println("1- credit card");
					System.out.println("2- cash");
					System.out.println("3- wallet");
					System.out.print("Enter: ");
					cs = sc.nextInt();
					if (cs == 1) {
						payment = new CreditCard();

					} else if (cs == 2) {
						payment = new Cash();

					} else {
						payment = new Wallet();

					}

					t = payment.Pay(t);
					payment = new OverallDiscounts(payment);
					t = payment.Pay(t);
					payment = new SpecificDiscount(payment);
					t = payment.Pay(t);
					System.out.println("Final value: " + t.getAmount());
					// ------------------------ 6
					// -----------------------------------------------------------------------

				} else if (ch == 6) {
					HashMap<String, Integer> discounts = ctrl.getDiscounts();

					int i = 1;
					for (String name : discounts.keySet()) {
						if (discounts.get(name) != 0) {
							System.out.println(i + "- " + name + " = " + discounts.get(name));
							i++;
						}
					}
					// ------------------------ 7
					// -----------------------------------------------------------------------

				} else if (ch == 7) {
					break;
				}

			} catch (Exception e) {

			}

		}

	}

}
