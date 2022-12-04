package factoryMethod;

interface ServiceProviderFactory {

	MobileService createService(int type);
}
