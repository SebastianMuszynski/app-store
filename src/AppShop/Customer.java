package AppShop;
import java.util.ArrayList;

public class Customer extends User implements java.io.Serializable{

	private String name;
	private String address;
	private String profession;
	private ArrayList<App> apps;
	
	public Customer(String username, String password, String name, String address, String profession) {
		super(username, password);
		this.name = name;
		this.address = address;
		this.profession = profession;
		apps = new ArrayList<App>(); 
		save();
	}
	
	public double getAppPercentageDiscount() {
		return 0;
	}
	
	public int appsNumber() {
		return apps.size();
	}
	
	public void addApp(App app) {
		apps.add(app);
		save();// save the newly added app to our file.
	}
	
	/**
	 * @return number of apps used as a free trial. 
	 */
	public int freeAppsNumber() {
		return apps.size() - paidAppsNumber();
	}
	
	/**
	 * @return number of purchased apps. 
	 */
	public int paidAppsNumber() {
		int number = 0;
		for(int i = 0; i < apps.size(); i++)
			if(apps.get(i) instanceof PaidApp)
				number++;
		return number;
	}
	
	public double amountToPaidForApps() {
		double cost = 0;
		for(App app : apps)
			if(app instanceof PaidApp)
				cost += ((PaidApp) app).getDiscountedCost(this);
		return cost;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getProfession() {
		return profession;
	}
	
	public void setProfession(String profession) {
		this.profession = profession;
	}
	
	public String toString() {
		return name + " (" + username + ")";
	}
	
	/**
	 * Doesn't need to check if the file exists before and can happily overwrite.
	 * This is because the customer file is constantly being updated with new 
	 * information from the system, no information needs to be preserved.
	 */
	public void save(){
		Serialiser.serialise(this, "data/customers/"+username+".appstore");
	}

}
