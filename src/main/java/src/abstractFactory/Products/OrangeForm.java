package src.abstractFactory.Products;

import java.util.ArrayList;

public class OrangeForm extends IForm {
    @Override
    public ArrayList<String> createForm() {
        fields = new ArrayList<>();
        fields.add("Enter mobile number");
        fields.add("Enter amount");
        fields.add("Please enter which payment method(1 -> cash, 2 -> credit card, 3 -> your wallet )");
        fields.add(" select on of them (0 -> no thing to choose ,1 -> Orange 25,2 -> Orange 50,3 -> Orange 100");
        return fields;
    }
}
