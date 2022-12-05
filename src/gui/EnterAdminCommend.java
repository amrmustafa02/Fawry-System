package gui;

import java.util.Scanner;

public class EnterAdminCommend implements ICommend {

	@Override
	public void draw() {
		Scanner sc = new Scanner(System.in);
		Invoker invoker = new Invoker();

		int ch;

		while (true) {
			System.out.println("------------------------------");
			System.out.println("| 1- add Discound             |");
			System.out.println("| 2- Show all refund equest   |");
			System.out.println("| 3- Show all transaction     |");
			System.out.println("| 4-back                      |");
			System.out.println("-------------------------------");

			try {
				System.out.print("Enter choice: ");
				ch = sc.nextInt();
				if (ch == 1) {
					invoker.execute(new AdminAddDiscountComment());

				} else if (ch == 2) {
                 
				} else if (ch == 3) {

				} else if (ch == 4) {
					break;
				}
			} catch (Exception e) {

			}

		}
	}

}
