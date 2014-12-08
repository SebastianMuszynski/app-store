package AppShop;

public class App {
	private String name;
	private String description;
	private String developerName;
	private int purchasesNumber;
	private Category category;
	protected double cost = 0;
	
	public App(String name, String description, String developerName, Category category) {
		this.name = name;
		this.description = description;
		this.developerName = developerName;
		this.category = category;
	}
	
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
	
	public String toString() {
		return name + " by " + developerName + " (" + category + ")";
	}
	
}
