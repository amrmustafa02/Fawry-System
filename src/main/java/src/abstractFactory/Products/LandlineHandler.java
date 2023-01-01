package src.abstractFactory.Products;

import src.models.Transaction;

import java.util.ArrayList;

public class LandlineHandler implements IHandler {
    @Override
    public String handleForm(ArrayList<String> inputs, Transaction transaction) {
        String phone = inputs.get(1);
        String amount = inputs.get(2);
        if (phone.length() < 7 || phone.length() > 8)
            return "phone number must be between 7 to 8 numbers after +02";

        if (phone.charAt(0) != '0' || phone.charAt(1) != '2')
            return "Wrong number,must start with 02";

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
