package src.abstractFactory.FactoryProviders;

import src.abstractFactory.Products.IForm;
import src.abstractFactory.Products.IHandler;
import src.abstractFactory.Products.OrangeForm;
import src.abstractFactory.Products.OrangeHandler;

public class OrangeFactory implements ServiceProvider {
    @Override
    public IForm createForm() {
        return new OrangeForm();
    }

    @Override
    public IHandler getHandler() {
        return new OrangeHandler();
    }
}
