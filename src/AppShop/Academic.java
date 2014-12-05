package AppShop;

public class Academic extends Customer {
	private static final double APP_PERCENTAGE_DISCOUNT = 10;

	public Academic(String name, String address, String profession) {
		super(name, address, profession);
	}
	
	public double getAppPercentageDiscount() {
		return APP_PERCENTAGE_DISCOUNT;
	}
	
}
