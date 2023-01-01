package src.abstractFactory.FactoryProviders;

import src.abstractFactory.Products.IForm;
import src.abstractFactory.Products.IHandler;
import src.abstractFactory.Products.VodafoneForm;
import src.abstractFactory.Products.VodafoneHandler;

public class VodafoneFactory implements ServiceProvider {
    @Override
    public IForm createForm() {
        return new VodafoneForm();
    }

    @Override
    public IHandler getHandler() {
        return new VodafoneHandler();
    }
}
