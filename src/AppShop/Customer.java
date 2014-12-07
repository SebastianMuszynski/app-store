package AppShop;
import java.util.ArrayList;

public class Customer extends User {
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
	}
	
	public double getAppPercentageDiscount() {
		return 0;
	}
	
	public int appsNumber() {
		return apps.size();
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

}
