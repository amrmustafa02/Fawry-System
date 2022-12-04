package abstractFactory;

public class EtislatFactory implements ServiceProviderFactory {

	@Override
	public MobileService createMobileService(int type) {
		return new EtislatMobileService();
	}

	@Override
	public InternetService createInternetService(int type) {
		return new EtislatIternetService();
	}

}
