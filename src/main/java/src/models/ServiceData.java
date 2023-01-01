package src.models;

import src.abstractFactory.FactoryProviders.ServiceProvider;
import src.abstractFactory.Products.IForm;

import java.util.ArrayList;

public class ServiceData {

    private String name;
    private static int ID = 1;
    private int id;
    private ServiceProvider provider;

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    private int discount;

    public ServiceData(String name, ServiceProvider provider) {
        this.name = name;
        this.provider = provider;
        id = ID;
        ID++;
    }


    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public ServiceProvider serviceProvider() {
        return provider;
    }

    public ArrayList<String> getForm() {
        IForm form = provider.createForm();
        return form.createForm();
    }

}
