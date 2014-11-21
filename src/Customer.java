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
