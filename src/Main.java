
public class Main {
	
	public static void main(String[] args) {
		System.out.println("just testing git");
		Shop shop = new Shop();
		System.out.println("Shop info:");
		System.out.println("Total number of purchased apps: " + shop.purchasedAppsNumber());
		System.out.println("Total number of customers: " + shop.customersNumber());
	}

}
