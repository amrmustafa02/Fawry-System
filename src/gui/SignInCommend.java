package gui;

import java.util.Scanner;

import controllers.EnterToSystem;

public class SignInCommend implements ICommend {
	Scanner sc = new Scanner(System.in);
	String password, email;
	EnterToSystem contoller = new EnterToSystem();

	@Override
	public void draw() {

		try {
			// take email from user
			System.out.print("\nEnter Your Email: ");
			email = sc.next();

			System.out.print("Enter Your Password: ");
			password = sc.next();

			Boolean check = contoller.signIn(email, password);

			if (check == true) {
				System.out.print("user is exsit");
				Invoker in = new Invoker();

				in.execute(new UserMenuCommend());

			} else {
				System.out.print("user not found");

			}

		} catch (Exception e) {

		}
		

	}

}
