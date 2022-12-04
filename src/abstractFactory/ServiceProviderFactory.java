package abstractFactory;

interface ServiceProviderFactory {

	MobileService createMobileService(int type);

	InternetService createInternetService(int type);
}
