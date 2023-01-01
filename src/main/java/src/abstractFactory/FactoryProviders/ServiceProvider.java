package src.abstractFactory.FactoryProviders;

import src.abstractFactory.Products.IForm;
import src.abstractFactory.Products.IHandler;
import src.abstractFactory.Products.WeHandler;

public interface ServiceProvider {
     IForm createForm();
     IHandler getHandler();
}
