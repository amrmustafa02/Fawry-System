package gui;

import java.util.Scanner;

public class EnterUserCommend implements ICommend {

	@Override
	public void draw() {
		// start go do sign in and sign up
		Scanner sc = new Scanner(System.in);
		int ch;
		Invoker invoker = new Invoker();
		
		while (true) {
			System.out.println("\n\n---------------");
			System.out.println("|1- Sign In   |");
			System.out.println("|2- Sign up   |");
			System.out.println("|3- back      |");
			System.out.println("---------------");
			System.out.print("Enter choice: ");

			try {
				ch = sc.nextInt();
				if (ch == 1) {
					invoker.execute(new EnterUserCommend());
				} else if (ch == 2) {
					invoker.execute(new EnterUserCommend());
				} else if (ch == 3) {
					sc.close();
					return;
				}
			} catch (Exception e) {

			}

		}
	}

}
