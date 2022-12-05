package abstractFactory;

public interface ServiceProviderFactory {

	MobileService createMobileService(int type);

	InternetService createInternetService(int type);
}
