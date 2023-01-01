
package src.payment;


import src.models.*;

public class Wallet implements IPaymentMethod {


    @Override
    public Transaction Pay(Transaction t, Database db) {
        t.setPaymentMethod("wallet");

        User currentUser = db.getCurUser();
        float amount = t.getAmount();

        if (currentUser.getBalance() >= amount) {
            db.getCurUser().removeFromWallet(amount);
            return t;
        } else {
            return null;
        }
    }
}
