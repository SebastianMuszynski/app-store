package AppShop;


public class Main {
	
	public static void main(String[] args) {
		Shop shop = new Shop();
		System.out.println("Shop info:");
		System.out.println("Total number of purchased apps: " + shop.appsNumber());
		System.out.println("Total number of customers: " + shop.customersNumber());
		
		shop.listApps();
		
		System.out.println();
		
		Customer student = new Student("jack123", "qwerty", "Jack", "Los Angeles", "web developer");
		Customer academic = new Academic("jack456", "myPassword", "Jack", "Los Angeles", "web developer");
		
		System.out.println("Student info:");
		System.out.println("Number of free apps: " + student.freeAppsNumber());
		System.out.println("Number of paid apps: " + student.paidAppsNumber());
		
		App app = new App("Flappy Bird", "Flapping bird game.", "Dev Name", Category.NEWS);
		System.out.println("App type is " + app.getCategoryName());
		
		PaidApp paidApp = new PaidApp("Flappy Bird", "Flapping bird game.", "Dev Name", Category.NEWS, 12.50);
		System.out.println("PaidApp price for student: " + paidApp.getDiscountedCost(student));
		System.out.println("PaidApp price for academic: " + paidApp.getDiscountedCost(academic));
	}

}
