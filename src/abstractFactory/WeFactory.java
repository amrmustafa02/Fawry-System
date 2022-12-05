package abstractFactory;

public class WeFactory implements ServiceProviderFactory {

	@Override
	public MobileService createMobileService() {
		return new WeMobileService();
	}

	@Override
	public InternetService createInternetService() {
		return new WeInternetService();
	}


}
