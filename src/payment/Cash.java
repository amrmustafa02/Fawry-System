package payment;

public class Cash implements IPaymentMethod {

	@Override
	public Boolean Pay(int amount) {
		System.out.print("sucussful transaction and your amount is " + amount);

		return true;

	}

}
