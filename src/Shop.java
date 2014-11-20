import java.util.ArrayList;

public class Shop {
	ArrayList<App> apps;
	ArrayList<Customer> customers;
	
	public Shop() {
		apps = new ArrayList<App>();
		customers = new ArrayList<Customer>();
	}

	/**
	 * @return total number of apps which have been purchased
	 */
	public int purchasedAppsNumber() {
		return apps.size();
	}
	
	/**
	 * @return total number of customers
	 */
	public int customersNumber() {
		return customers.size();
	}

}
