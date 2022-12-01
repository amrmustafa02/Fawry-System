package database;

public class Transaction {
	private float Amount=0;
	private String Type;
	private static int  Id=0;
	private int Tid;
	public float getAmount() {
		return Amount;
	}
	public void setAmount(float amount) {
		Amount = amount;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public int getTid() {
		return Tid;
	}
	public Transaction(float amount, String type) {
		Amount = amount;
		Type = type;
		Tid=Id;
		Id++;
	}
	
	
	
	
	

}
