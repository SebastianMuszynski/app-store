import java.util.ArrayList;

public abstract class Customer {
	private String name;
	private String address;
	private String profession;
	private ArrayList<App> apps;
	
	public Customer(String name, String address, String profession) {
		this.name = name;
		this.address = address;
		this.profession = profession;
		apps = new ArrayList<App>(); 
	}
	
	/**
	 * @return number of apps used as a free trial. 
	 */
	public int numberOfFreeApps() {
		return apps.size() - numberOfPaidApps();
	}
	
	/**
	 * @return number of purchased apps. 
	 */
	public int numberOfPaidApps() {
		int number = 0;
		for(int i = 0; i < apps.size(); i++)
			if(apps.get(i) instanceof PaidApp)
				number++;
		return number;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getProfession() {
		return profession;
	}

}
