package src.decorter;

import src.models.Database;
import src.models.Transaction;
import src.payment.IPaymentMethod;

public class SpecialDiscount extends DiscountDecorator {
    public SpecialDiscount(IPaymentMethod method, Database db) {
        super(method, db);
    }

    @Override
    public float addDiscount(Transaction t) {


        float amount = t.getAmount();

        int dis = db.getSpecialDiscount(t.getSid());
        amount -= (amount * (dis / 100.0));

        return amount;


    }

    public Transaction Pay(Transaction amount, Database db) {
        float newAmount = addDiscount(amount);
        amount.setAmount(newAmount);
        return amount;

    }
}
