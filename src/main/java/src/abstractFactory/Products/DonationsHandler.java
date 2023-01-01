package src.abstractFactory.Products;

import src.models.Transaction;

import java.util.ArrayList;

public class DonationsHandler implements IHandler {
    @Override
    public String handleForm(ArrayList<String> inputs, Transaction transaction) {

        try {
            int amount = Integer.parseInt(inputs.get(2));
            transaction.setAmount(amount);
        } catch (Exception e) {
            return "please check in position 3 is amount(Integer)";
        }

        return "ok";
    }
}
