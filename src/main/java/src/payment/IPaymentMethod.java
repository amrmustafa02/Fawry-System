package src.payment;


import src.models.Database;
import src.models.Transaction;

public interface IPaymentMethod {

	Transaction Pay(Transaction amount, Database db);
}
