import java.util.Scanner;

import gui.EnterUserCommend;
import gui.Invoker;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice;

		Invoker invoker = new Invoker();

		while (true) {
			System.out.println("\n\n-------------------");
			System.out.println("|1- user          |");
			System.out.println("|2- admin         |");
			System.out.println("|3- Exist         |");
			System.out.println("-------------------");
			System.out.print("Enter choice: ");

			try {
				choice = sc.nextInt();
				if (choice == 1) {
                       invoker.execute(new EnterUserCommend());
				} else if (choice == 2) {
                    invoker.execute(new EnterUserCommend());

				} else if (choice == 3) {
              break;
				}

			} catch (Exception e) {

			}

		}
		sc.close();

	}

}
