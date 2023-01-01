package src.decorter;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import src.models.*;
import src.payment.IPaymentMethod;

import java.util.ArrayList;

public class OverallDiscounts extends DiscountDecorator {

    public OverallDiscounts(IPaymentMethod p, Database db) {
        super(p, db);
    }

    @Override
    public float addDiscount(Transaction t) {
        float amount = t.getAmount();
        int dis = db.getOverAllDiscounts();
        amount -= (amount * (dis / 100.0));
        return amount;
    }

    public Transaction Pay(Transaction amount, Database db) {
        float newAmount = addDiscount(amount);
        amount.setAmount(newAmount);
        return amount;

    }


}

