

package src.payment;

import src.models.Database;
import src.models.Transaction;

public class CreditCard implements IPaymentMethod {


    @Override
    public Transaction Pay(Transaction amount, Database db) {
        amount.setService("use credit card");
        return amount;
    }
}
