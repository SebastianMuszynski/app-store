
public class Main {
	
	public static void main(String[] args) {
		Shop shop = new Shop();
		System.out.println("Shop info:");
		System.out.println("Total number of purchased apps: " + shop.purchasedAppsNumber());
		System.out.println("Total number of customers: " + shop.customersNumber());
		
		System.out.println();
		
		Customer student = new Student("Jack", "Los Angeles", "web developer");
		System.out.println("Student info:");
		System.out.println("Number of free apps: " + student.numberOfFreeApps());
		System.out.println("Number of paid apps: " + student.numberOfPaidApps());
	}

}
