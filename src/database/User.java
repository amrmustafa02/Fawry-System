package database;
import java.util.*;
public class User {
	
	private String UserName;
	private String Email;
	private String Password;
	private float balance;
	private  static int Id=0;
	private int SpecialId;
	private Vector<Transaction> transactions;// arrayof transcations
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public int getId() {
		return SpecialId;
	}
	public User(String userName, String email, String password, float balance) {
		UserName = userName;
		Email = email;
		Password = password;
		this.balance = balance;
		SpecialId=Id;
		Id+=1;
		transactions=new Vector <>();
		
	}
	public int addTransaction(Transaction t)
	{
		transactions.add(t);
	}
	
}