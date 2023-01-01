package src.abstractFactory.FactoryProviders;

import src.abstractFactory.Products.IForm;
import src.abstractFactory.Products.IHandler;
import src.abstractFactory.Products.WeForm;
import src.abstractFactory.Products.WeHandler;


public class WeFactory implements ServiceProvider {

    @Override
    public IForm createForm() {
        return new WeForm();
    }

    @Override
    public IHandler getHandler() {
        return new WeHandler();
    }
}
