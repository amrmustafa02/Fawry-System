package src.abstractFactory.Products;

import java.util.ArrayList;

public class DonationsForm extends IForm {
    @Override
    public ArrayList<String> createForm() {
        fields = new ArrayList<>();
        fields.add("Enter bank account for organization");
        fields.add("Enter amount for donation");
        fields.add("Please enter which payment method(2 -> credit card, 3 -> your wallet )");
        return fields;
    }
}
