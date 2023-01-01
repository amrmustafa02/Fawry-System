package src.abstractFactory.Products;

import java.util.ArrayList;

public abstract class IForm {
   protected ArrayList<String> fields = new ArrayList<>();

    public abstract ArrayList<String> createForm();


}
