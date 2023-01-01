package src.decorter;

import src.models.Database;
import src.models.Transaction;
import src.payment.IPaymentMethod;

public abstract class DiscountDecorator implements IPaymentMethod {
    protected IPaymentMethod method;

    protected Database db;

    public abstract float addDiscount(Transaction t);

    public DiscountDecorator(IPaymentMethod method, Database db) {
        this.method = method;
        this.db = db;
    }

    @Override
    public Transaction Pay(Transaction t, Database db) {
        return method.Pay(t, db);
    }

}