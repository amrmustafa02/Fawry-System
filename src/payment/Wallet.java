package payment;

import database.*;

public class Wallet implements IPaymentMethod {

	@Override
	public Boolean Pay(int amount) {
		DataBase db = DataBase.getInstance();
		User currentUser = db.getCurrentUser();

		if (currentUser.getBalance() >= amount) {
			currentUser.removeFromWalltet(amount);
			System.out.println("accepted transaction");
			return true;
		} else {
			System.out.println("wallet not have money");
			return false;
		}

	}

}
