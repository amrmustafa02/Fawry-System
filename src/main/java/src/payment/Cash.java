package src.payment;


import src.models.Database;
import src.models.Transaction;

public class Cash implements IPaymentMethod {


    @Override
    public Transaction Pay(Transaction amount, Database db) {
        amount.setPaymentMethod("cash");
        return amount;
    }
}
