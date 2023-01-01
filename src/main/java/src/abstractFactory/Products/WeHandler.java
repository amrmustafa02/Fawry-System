package src.abstractFactory.Products;

import src.models.Transaction;

import java.util.ArrayList;

public class WeHandler implements IHandler {
    @Override
    public String handleForm(ArrayList<String> inputs, Transaction transaction) {
        String phone = inputs.get(1);
        String amount = inputs.get(2);

        // handle phone number
        if (phone.length() != 11)
            return "phone number must contain of 11 number";

        if (phone.charAt(0) != '0' || phone.charAt(1) != '1' || phone.charAt(2) != '5')
            return "Wrong number,must start with 015";

        /*
          handle amount
         convert it to int and assign it to transaction
        */
        try {
            int amount2 = Integer.parseInt(amount);
            transaction.setAmount(amount2);

        } catch (Exception e) {
            return "wrong data,please check on amount";
        }

        return "ok";
    }
}
