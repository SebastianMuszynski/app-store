
public class App {
	private String name;
	private String description;
	private String developerName;
	private String category; // News, Games, Social Networking, Travel, etc.
	private String type; // free trial OR for purchasing
	private int purchasesNumber; // the popularity of the app
	
	public App(String name, String description, String developerName, String category, String type) {
		this.name = name;
		this.description = description;
		this.developerName = developerName;
		this.category = category;
		this.type = type;
	}
	
	/**
	 * TODO: work out the cost of the app
	 * @return calculated cost of the app
	 */
	public double cost() {
		return 0;
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
	
	public String getCategory() {
		return category;
	}
	
	public String getType() {
		return type;
	}
	
	public int getPurchasesNumber() {
		return purchasesNumber;
	}
}
