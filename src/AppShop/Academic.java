package AppShop;

public class Academic extends Customer {
	private static final double APP_PERCENTAGE_DISCOUNT = 10;

	public Academic(String username, String password, String name, String address, String profession) {
		super(username, password, name, address, profession);
	}
	
	public double getAppPercentageDiscount() {
		return APP_PERCENTAGE_DISCOUNT;
	}
	
}
