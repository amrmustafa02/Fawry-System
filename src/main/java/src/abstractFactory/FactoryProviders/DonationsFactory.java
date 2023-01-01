package src.abstractFactory.FactoryProviders;

import src.abstractFactory.Products.DonationsForm;
import src.abstractFactory.Products.DonationsHandler;
import src.abstractFactory.Products.IForm;
import src.abstractFactory.Products.IHandler;

public class DonationsFactory implements ServiceProvider {
    @Override
    public IForm createForm() {
        return new DonationsForm();
    }

    @Override
    public IHandler getHandler() {
        return new DonationsHandler();
    }
}
