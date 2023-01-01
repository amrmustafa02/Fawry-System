package src.models;

import java.util.ArrayList;

public class User {

    private String password;
    private String userName;
    private String email;
    private float balance = 0;
    private ArrayList<Transaction> transactions = new ArrayList<>();// array of transactions
    private final ArrayList<Transaction> refundTransactions = new ArrayList<>();


    public ArrayList<Transaction> getRefundTransactions() {
        return refundTransactions;
    }

    public String getPassword() {
        return password;
    }


    public String getUserName() {
        return userName;
    }


    public String getEmail() {
        return email;
    }


    public float getBalance() {
        return balance;
    }

    public void addToWallet(float amount) {
        this.balance += amount;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void removeFromWallet(float balance) {
        this.balance -= balance;
    }

    public void addTransaction(Transaction t) {
        transactions.add(t);

    }

    public void removeFromTransaction(int tid) {

        for (Transaction transaction : transactions) {
            if (transaction.getTid() == tid) {
                refundTransactions.add(transaction);
                transactions.remove(transaction);
                break;
            }
        }

    }
}
