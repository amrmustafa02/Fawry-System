package abstractFactory;

public class EtislatFactory implements ServiceProviderFactory {

	@Override
	public MobileService createMobileService() {
		return new EtislatMobileService();
	}

	@Override
	public InternetService createInternetService() {
		return new EtislatIternetService();
	}

}
