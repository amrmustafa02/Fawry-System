package abstractFactory;

public interface ServiceProviderFactory {

	MobileService createMobileService();

	InternetService createInternetService();
}
