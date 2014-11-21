
public abstract class Customer {
	private String name;
	private String address;
	private String profession;
	
	public Customer(String name, String address, String profession) {
		this.name = name;
		this.address = address;
		this.profession = profession;
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
