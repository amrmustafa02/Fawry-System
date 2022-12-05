package abstractFactory;

public class OrangeFactory implements ServiceProviderFactory {

	@Override
	public MobileService createMobileService() {
		return new OrangeMobileService();
	}

	@Override
	public InternetService createInternetService() {
		return new OrangeInternetService();
	}

}
