package gui;

public class EnterAdminCommend implements ICommend {

	@Override
	public void draw() {
		Scanner sc = new Scanner(System.in);
        int ch;

        while (true) {
            System.out.println("------------------------------");
            System.out.println("| 1- add Discound              |");
            System.out.println("| 2- Show all refund equest   |");
            System.out.println("| 3- Show all transaction     |");
            System.out.println("| 4-back     |");
            System.out.println("-------------------------------");

            try {
                System.out.print("Enter choice: ");
                ch = sc.nextInt();
                if (ch == 1) {

                } else if (ch == 2) {

                } else if (ch == 3) {

                } else if (ch == 4) {

                }
            } catch (Exception e) {

            }

        }
	}

}
