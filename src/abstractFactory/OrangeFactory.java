package abstractFactory;

public class OrangeFactory implements ServiceProviderFactory {

	@Override
	public MobileService createMobileService(int type) {
		return new OrangeMobileService();
	}

	@Override
	public InternetService createInternetService(int type) {
		return new OrangeInternetService();
	}

}
