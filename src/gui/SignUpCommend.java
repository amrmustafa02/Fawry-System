package gui;

import java.util.Scanner;

import controllers.EnterToSystem;

public class SignUpCommend implements ICommend {

	Scanner sc = new Scanner(System.in);
	String userName, email, password;
	
	// control
	EnterToSystem controller = new EnterToSystem();

	@Override
	public void draw() {
		try {
			// take user name
			System.out.print("\nEnter Your user name: ");
			userName = sc.nextLine();

			// take email
			System.out.print("Enter Your email : ");
			email = sc.nextLine();

			// take password
			System.out.print("Enter Your Password: ");
			password = sc.nextLine();
			
			// search on this user and if not exist insert it
			
			Boolean check = controller.signUp(userName, email, password);

			if(check==true) {
				System.out.println("new user added");
			}else {
				System.out.print("user is already exist");
			}
			
		} catch (Exception e) {
           System.out.println("Error");
		};

	}

}
