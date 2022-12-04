package database;

import java.util.*;

public class User {

	private String UserName;
	private String Email;
	private String Password;
	private float balance;
	private static int ID = 1;
	private int SpecialId;
	private Vector<Transaction> transactions;// array of transactions

	public String getUserName() {
		return UserName;
	}

	public String getEmail() {
		return Email;
	}

	public String getPassword() {
		return Password;
	}

	public float getBalance() {
		return balance;
	}

	public void addToWallet(float balance) {
		this.balance += balance;
	}

	public int getId() {
		return SpecialId;
	}

	public User(String userName, String email, String password) {
		UserName = userName;
		Email = email;
		Password = password;
		SpecialId = ID;
		transactions = new Vector<>();
		ID++;
	}

	public void addTransaction(Transaction t) {
		transactions.add(t);
	}

	public Vector<Transaction> getTransaction() {
		return transactions;
	}

	public void removeFromWalltet(int balance) {
		this.balance -= balance;
	}

}