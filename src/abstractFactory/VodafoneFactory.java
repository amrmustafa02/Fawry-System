package abstractFactory;

public class VodafoneFactory implements ServiceProviderFactory {

	@Override
	public MobileService createMobileService(int type) {
		return new VodafoneMobileService();
	}

	@Override
	public InternetService createInternetService(int type) {
		return new VodafoneInternetService();

	}

}
