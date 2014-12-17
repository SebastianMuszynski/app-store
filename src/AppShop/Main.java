package AppShop;


public class Main {
	
	public static void main(String[] args) {
		Shop shop = new Shop();
		System.out.println("Shop info:");
		System.out.println("Total number of purchased apps: " + shop.appsNumber());
		System.out.println("Total number of users: " + shop.usersNumber());
		
		shop.listApps();
		
		System.out.println();
		
		Customer student = (Student)Serialiser.deserialise("data/customers/jack123.appstore");
		Customer academic = new Academic("jack456", "myPassword", "Jack", "Los Angeles", "web developer");
		
		System.out.println(student.toString());
		
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
