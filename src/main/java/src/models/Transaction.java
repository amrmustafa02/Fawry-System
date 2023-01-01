package src.models;

public class Transaction {
    private float amount = 0;
    private String paymentMethod;
    private String service;
    private static int ID = 1;
    private int Tid;
    private int sid;
    private String status;

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getTid() {
        return Tid;
    }


    public void setId() {
        Tid = ID;
        ID++;
    }

    public Transaction() {
        status = "accepted transaction";
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getSid() {
        return sid;
    }

    public String getStatus() {
        return status;
    }
}