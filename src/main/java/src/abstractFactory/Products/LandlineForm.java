package src.abstractFactory.Products;

import java.util.ArrayList;

public class LandlineForm extends IForm {
    @Override
    public ArrayList<String> createForm() {
        fields = new ArrayList<>();
        fields.add("Enter home phone: ");
        fields.add("Enter amount: ");
        fields.add("Please enter which payment method(1 -> cash, 2 -> credit card, 3 -> your wallet )");
        return fields;
    }
}
