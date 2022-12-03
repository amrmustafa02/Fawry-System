package gui;

import java.util.Scanner;

public class UserMenuCommend implements ICommend {

	Scanner sc = new Scanner(System.in);
	int ch;

	@Override
	public void draw() {
		while (true) {
			System.out.println("\n1- Search");
			System.out.println("2- show my transaction");
			System.out.println("3- show my refund requests");
			System.out.println("4- request refund");
			System.out.println("5- add to wallet");
			System.out.println("6- show services ");
			System.out.println("7- Exist\n");
			System.out.print("Enter your choice: ");
			try {
				ch = sc.nextInt();
				if (ch == 1) {
					System.out.print("Enter service name: ");
					// take string matching
					String name = sc.nextLine();

				} else if (ch == 2) {

				}

			} catch (Exception e) {

			}

		}

	}

}
