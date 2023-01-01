package src.abstractFactory.Products;

import src.models.Transaction;

import java.util.ArrayList;

public class EtisalatHandler implements IHandler {

    @Override
    public String handleForm(ArrayList<String> inputs, Transaction transaction) {
        String phone = inputs.get(1);
        String amount = inputs.get(3);


        // handle phone number
        if (phone.length() != 11)
            return "phone number must contain of 11 number";

        if (phone.charAt(0) != '0' || phone.charAt(1) != '1' || phone.charAt(2) != '1')
            return "Wrong number,must start with 011";

        /*
          handle amount
         convert it to INT and assign it to transaction
        */
        try {
            int amount2 = Integer.parseInt(amount);
            if (amount2 == 1)
                amount2 = 100;
            else if (amount2 == 2)
                amount2 = 25;
            else if (amount2 == 3)
                amount2 = 50;
            else {
                return "please back to form and choose your system from 1 to 3";
            }
            transaction.setAmount(amount2);

        } catch (Exception e) {
            return "wrong data,please check on that";
        }

        return "ok";
    }
}
