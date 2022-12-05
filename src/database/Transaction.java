package database;

public class Transaction {
	private float Amount=0;
	private String Type;
	private String service;
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
	public Transaction() {
		
		Tid=Id;
		Id++;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	
	
	
	
	

}
