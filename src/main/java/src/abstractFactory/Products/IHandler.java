package src.abstractFactory.Products;


import src.models.Transaction;

import java.util.ArrayList;

public interface IHandler {

     String handleForm(ArrayList<String> inputs, Transaction transaction);

}
