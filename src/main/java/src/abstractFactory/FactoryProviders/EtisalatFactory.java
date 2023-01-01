package src.abstractFactory.FactoryProviders;

import src.abstractFactory.Products.EtisalatForm;
import src.abstractFactory.Products.EtisalatHandler;
import src.abstractFactory.Products.IForm;
import src.abstractFactory.Products.IHandler;

public class EtisalatFactory implements ServiceProvider {
    @Override
    public IForm createForm() {
        return new EtisalatForm();
    }

    @Override
    public IHandler getHandler() {
        return new EtisalatHandler();
    }
}
