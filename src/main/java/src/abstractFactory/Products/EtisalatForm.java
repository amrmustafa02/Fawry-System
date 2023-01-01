package src.abstractFactory.Products;

import java.util.ArrayList;

public class EtisalatForm extends IForm {
    @Override
    public ArrayList<String> createForm() {

        fields = new ArrayList<>();
        fields.add("Enter mobile number: ");
        fields.add("Please enter which payment method(1 -> cash, 2 -> credit card, 3 -> your wallet )");
        fields.add(" select on of them (1 -> Akwa kart Mega x,2 -> Akwa kart social Media,3 -> Akwa kart Mega video Bundle");
        return fields;
    }
}
