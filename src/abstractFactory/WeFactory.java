package abstractFactory;

public class WeFactory implements ServiceProviderFactory {

	@Override
	public MobileService createMobileService(int type) {
		return new WeMobileService();
	}

	@Override
	public InternetService createInternetService(int type) {
		return new WeInternetService();
	}


}
