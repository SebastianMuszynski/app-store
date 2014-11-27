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
	
	/**
	 * It adds new app to the shop.
	 * @param app – newly created app.
	 */
	public void addApp(App app) {
		apps.add(app);
	}
	
	/**
	 * It adds new customer to the shop.
	 * @param customer – newly created customer.
	 */
	public void addCustomer(Customer customer) {
		customers.add(customer);
	}
	
	/**
	 * It lists all the apps from the shop.
	 * TODO: implement toString() method in the App
	 */
	public void listApps() {
		for(int i = 0; i < apps.size(); i++)
			System.out.println(apps.get(i));
	}
	
	/**
	 * It lists all the customers from the shop.
	 * TODO: implement toString() method in the Customer
	 */
	public void listCustomers() {
		for(int i = 0; i < customers.size(); i++)
			System.out.println(customers.get(i));
	}
	
	/**
	 * It looks for the app by given app's name.
	 * @param name – name of the app we want to find.
	 * @return the app if it has been found, otherwise null.
	 */
	public App findAppByName(String name) {
		App app = null;
		for(int i = 0; i < apps.size() && app == null; i++) {
			App currentApp = apps.get(i);
			if(name == currentApp.getName()) 
				app = currentApp;
		}
		return app;
	}
	
	/**
	 * It deletes the given app from the shop.
	 * @param app – the app we want to delete.
	 */
	public void deleteApp(App app) {
		Integer appIndex = findAppIndex(app);
		if(appIndex != null)
			apps.remove(appIndex);
	}
	
	/**
	 * It deletes the given customer from the shop.
	 * @param customer – the customer we want to delete.
	 */
	public void deleteCustomer(Customer customer) {
		Integer customerIndex = findCustomerIndex(customer);
		if(customerIndex != null)
			customers.remove(customerIndex);
	}
	
	/**
	 * @param app – the app we are looking for.
	 * @return the index of given app, null if the app does not exist.
	 */
	public Integer findAppIndex(App app) {
		Integer appIndex = null;
		for(int i = 0; i < apps.size() && appIndex == null; i++)
			if(app == apps.get(i)) 
				appIndex = i;
		return appIndex;
	}
	
	/**
	 * @param customer – the customer we are looking for.
	 * @return the index of given customer, null if the customer does not exist.
	 */
	public Integer findCustomerIndex(Customer customer) {
		Integer customerIndex = null;
		for(int i = 0; i < customers.size() && customerIndex == null; i++)
			if(customer == customers.get(i)) 
				customerIndex = i;
		return customerIndex;
	}

}
