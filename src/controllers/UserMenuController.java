package controllers;

import java.util.HashMap;
import java.util.Vector;

import Decorter.*;
import abstractFactory.EtislatFactory;
import abstractFactory.InternetService;
import abstractFactory.MobileService;
import abstractFactory.OrangeFactory;
import abstractFactory.ServiceProviderFactory;
import abstractFactory.VodafoneFactory;
import abstractFactory.WeFactory;
import database.DataBase;
import database.Transaction;
import payment.*;

public class UserMenuController {
	private DataBase db = DataBase.getInstance();

	public float addToWallet(float amount) {
		db.getCurrentUser().addToWallet(amount);
		return db.getCurrentUser().getBalance();
	}

	public HashMap<String, Integer> getDiscounts() {
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

	public Transaction payService(int service, int provider, int pay) {
		Transaction t = new Transaction();
		ServiceProviderFactory factory;

		switch (provider) {
		case 1:
			factory = new WeFactory();
			break;
		case 2:
			factory = new EtislatFactory();
		
		case 3:
			factory = new VodafoneFactory();
		case 4:
			factory = new OrangeFactory();
			break;
		default:
			factory = new WeFactory();
		}

		if (service == 1) {
			t.setService("Mobile recharge");
			MobileService ser = factory.createMobileService();
			ser.createMobileService(t);

		} else if (service == 2) {
			t.setService("internet recharge");
			InternetService ser = factory.createInternetService();
			ser.createInternetService(t);
			

		} else if (service == 3) {
			t.setService("Landline");
			MobileService ser = factory.createMobileService();
			ser.createMobileService(t);

		} else if (service == 4) {
			t.setService("Donations");
			MobileService ser = factory.createMobileService();
			ser.createMobileService(t);

		}

		IPaymentMethod payment;

		if (pay == 1)
			payment = new CreditCard();
		else if (pay == 2)
			payment = new Cash();
		else
			payment = new Wallet();

		try {
			t = payment.Pay(t);
			payment = new OverallDiscounts(payment);
			t = payment.Pay(t);
			payment = new SpecificDiscount(payment);
			t = payment.Pay(t);
		} catch (Exception e) {

		}
		System.out.println("Final value: " + t.getAmount());
		db.getCurrentUser().addTransaction(t);
		return t;

	}
}
