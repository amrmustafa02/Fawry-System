package src.abstractFactory.FactoryProviders;

import src.abstractFactory.Products.*;

public class LandlineFactory implements ServiceProvider {
    @Override
    public IForm createForm() {
        return new LandlineForm();
    }

    @Override
    public IHandler getHandler() {
        return new LandlineHandler();
    }
}
