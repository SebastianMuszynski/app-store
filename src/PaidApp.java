
public class PaidApp extends App {

	public PaidApp(String name, String description, String developerName, Category category, double cost) {
		super(name, description, developerName, category);
		this.cost = cost;
	}
	
	/**
	 * @param customer – a customer who wants to buy an app.
	 * @return the discounted cost of the app for a given customer.  
	 */
	public double getDiscountedCost(Customer customer) {
		return (1 - customer.getAppPercentageDiscount()/100) * getCost();
	}
	
}
