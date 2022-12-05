package payment;

import database.*;

public class Wallet implements IPaymentMethod {

	@Override
	public Transaction Pay(Transaction t) {
		DataBase db = DataBase.getInstance();
		User currentUser = db.getCurrentUser();
		float amount = t.getAmount();

		if (currentUser.getBalance() >= amount) {
			currentUser.removeFromWalltet((int) amount);
			System.out.println("accepted transaction");
			return t;
		} else {
			System.out.println("wallet not have money");
			return t;
		}

	}

}
