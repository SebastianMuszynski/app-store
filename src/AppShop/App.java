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
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public String getDeveloperName() {
		return developerName;
	}
	
	public void setDeveloperName(String developerName) {
		this.developerName = developerName;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
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
	
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public String toString() {
		return name + " by " + developerName + " (" + category + ")";
	}
	
}
