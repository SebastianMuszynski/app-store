
public abstract class App {
	private String name;
	private String description;
	private String developerName;
	private int purchasesNumber; // the popularity of the app
	private double cost;
	private Category category;
	
	public App(String name, String description, String developerName, Category category, double cost) {
		this.name = name;
		this.description = description;
		this.developerName = developerName;
		this.category = category;
		this.cost = cost;
	}
	
	/**
	 * It calculates the cost of the app.
	 */
	public abstract double cost();
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getDeveloperName() {
		return developerName;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public String getCategoryName() {
		return category.getName();
	}
	
	public int getPurchasesNumber() {
		return purchasesNumber;
	}
	
	public double getCost() {
		return cost;
	}
	
}
