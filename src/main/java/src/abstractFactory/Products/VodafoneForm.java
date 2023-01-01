package src.abstractFactory.Products;

import java.util.ArrayList;

public class VodafoneForm extends IForm {
    @Override
    public ArrayList<String> createForm() {
        fields = new ArrayList<>();
        fields.add("Enter mobile number");
        fields.add("Please enter which payment method(1 -> cash, 2 -> credit card, 3 -> your wallet )");
        fields.add("select amount(1 -> flex 25, 2 -> flex 50, 3 -> flex 100");
        return fields;
    }
}
