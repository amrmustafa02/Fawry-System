package src.abstractFactory.Products;

import src.models.Transaction;

import java.util.ArrayList;

public class OrangeHandler implements IHandler {
    @Override
    public String handleForm(ArrayList<String> inputs, Transaction transaction) {

        String phone = inputs.get(1);
        String amount = inputs.get(2);
        String extra = inputs.get(4);

        // handle phone number
        if (phone.length() != 11)
            return "phone number must contain of 11 number";

        if (phone.charAt(0) != '0' || phone.charAt(1) != '1' || phone.charAt(2) != '2')
            return "Wrong number,must start with 012";

        /*
          handle amount
         convert it to int and assign it to transaction
        */
        int total = 0;
        try {
            total = Integer.parseInt(amount);
        } catch (Exception e) {
            return "wrong data,please check on amount";
        }

        try {
            int ex = Integer.parseInt(extra);
            if (ex == 1)
                ex = 25;
            else if (ex == 2)
                ex = 50;
            else if (ex == 3)
                ex = 100;
            total += ex;
        } catch (Exception e) {
            return "wrong data,please check on your selections ";
        }

        transaction.setAmount(total);

        return "ok";
    }
}
