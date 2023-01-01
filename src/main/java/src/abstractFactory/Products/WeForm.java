package src.abstractFactory.Products;

import java.util.ArrayList;

public class WeForm extends IForm{
    @Override
    public ArrayList<String> createForm() {
        fields = new ArrayList<>();
        fields.add("Enter mobile number: ");
        fields.add("Enter amount: ");
        fields.add("Please enter which payment method(1 -> cash, 2 -> credit card, 3 -> your wallet )");
        return fields;
    }

}
