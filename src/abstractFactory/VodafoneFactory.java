package abstractFactory;

public class VodafoneFactory implements ServiceProviderFactory {

	@Override
	public MobileService createMobileService() {
		return new VodafoneMobileService();
	}

	@Override
	public InternetService createInternetService() {
		return new VodafoneInternetService();

	}

}
