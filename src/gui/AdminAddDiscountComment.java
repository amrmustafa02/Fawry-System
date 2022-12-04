package gui;

import java.util.HashMap;
import java.util.Scanner;

import controllers.AdminMenuController;

public class AdminAddDiscountComment implements ICommend {

	@Override
	public void draw() {
		Scanner sc = new Scanner(System.in);
		AdminMenuController ctrl = new AdminMenuController();
		HashMap<String, Integer> discounts = ctrl.getDiscount();

		// take Overall or Specific

		System.out.println("1 - Overall discounts ");
		System.out.println("2- Specific discount");
		System.out.print("\nEnter choice: ");
		int whichDiscount = sc.nextInt();

		if (whichDiscount == 1) {
			int disountAmount;
			System.out.print("Enter discount amount: ");
			disountAmount = sc.nextInt();
			ctrl.addOverallDiscount(disountAmount);
		} else {

			// print services
			System.out.println("-------------------------------------");
			int i = 1;
			for (String service : discounts.keySet()) {
				System.out.println(i + "- " + service);
				i++;
			}
			System.out.println("-------------------------------------");

			System.out.print("Enter choice: ");
			try {
				int ch2 = sc.nextInt();
				String serviceName;
				if (ch2 == 2) {
					serviceName = "Mobile recharge";
				} else if (ch2 == 1) {
					serviceName = "internet recharge";
				} else if (ch2 == 3) {
					serviceName = "Landline";
				} else if (ch2 == 4) {
					serviceName = "Donations";
				} else {
					throw new Exception("Error");
				}
				int disountAmount;
				System.out.print("Enter discount amount: ");
				disountAmount = sc.nextInt();

				ctrl.addDiscount(serviceName, disountAmount);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

}
