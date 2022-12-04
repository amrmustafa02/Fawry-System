package controllers;

import java.util.HashMap;
import java.util.Vector;

import database.DataBase;
import database.Transaction;

public class UserMenuController {
	private DataBase db = DataBase.getInstance();

	public float addToWallet(float amount) {
		db.getCurrentUser().addToWallet(amount);
		return db.getCurrentUser().getBalance();
	}
	public HashMap<String, Integer> getDiscounts ( ) {
		return db.getDiscount();
	}
	public HashMap<Transaction, String> getRefundRequest() {
        HashMap<Transaction, String> userRefundsRequest = new HashMap<>();

        Vector<Transaction> userTransaction = db.getCurrentUser().getTransaction();
        HashMap<Integer, String> refundRequest = db.getRefundTransaction();

        for (Transaction t : userTransaction) {
            Integer getId = t.getTid();

            if (refundRequest.containsKey(getId) == true) {
                userRefundsRequest.put(t, refundRequest.get(getId));
            }
        }
        return userRefundsRequest;

    }
    public void addRefundRequest(Integer id) {
        db.addRefundRequest(id);
    }

}
  