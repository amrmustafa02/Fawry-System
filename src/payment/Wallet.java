package payment;

import database.*;

public class Wallet implements IPaymentMethod {

	@Override
	public void Pay(int amount) {
		DataBase db = DataBase.getInstance();
		User currentUser = db.getCurrentUser();

		if (currentUser.getBalance() >= amount) {
			currentUser.removeFromWalltet(amount);
			System.out.println("accepted transaction");
		} else {
			System.out.println("wallet not have money");
		}

	}

}
