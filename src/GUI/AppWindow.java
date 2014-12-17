package GUI;
import java.awt.EventQueue;

import javax.swing.JFrame;

import AppShop.Academic;
import AppShop.App;
import AppShop.Category;
import AppShop.Customer;
import AppShop.PaidApp;
import AppShop.Shop;
import AppShop.Student;
import GUI.Admin.AddAppPage;
import GUI.Admin.AddCustomerPage;
import GUI.Admin.EditAppPage;
import GUI.Admin.EditCustomerPage;
import GUI.Admin.ManageAppsPage;
import GUI.Admin.ManageCustomersPage;
import GUI.Admin.ShowAppPage;
import GUI.Admin.ShowCustomerPage;
import GUI.Customer.AppDetailsPage;
import GUI.Customer.ListAppsPage;


public class AppWindow {

	private static JFrame frame;
	public static final Shop SHOP = new Shop();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new AppWindow();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		addSampleData();
		setDefaultSettings();
		openHomePage();
		frame.setVisible(true);
	}
	
	private void addSampleData() {
		// Add students
		SHOP.addUser(new Student("jack123", "123123", "Jack Todd", "46 Kingston Upon Thames", "Web Developer"));
		SHOP.addUser(new Student("john2", "123123", "John Clarke", "1 Richmond",  "Engineering"));
		SHOP.addUser(new Student("sarah44", "123123", "Sarah Floyd", "85 Kew",  "Web Designer"));
		SHOP.addUser(new Student("peter26", "123123", "Peter Matthews",  "32 Ham",  "Doctor"));
		SHOP.addUser(new Student("jessie16", "123123", "Jessie Gomes",  "101 Esher", "Photographer"));
		// Add academics
		SHOP.addUser(new Academic("kelly123", "123123", "Kelly Hale", "142 Wimbledon", "Audio Engineer"));
		SHOP.addUser(new Academic("laura2", "123123", "Laura Jefferson", "65 Putney",  "Childcare Worker"));
		SHOP.addUser(new Academic("jason44", "123123", "Jason Moore", "91 Clapham",  "Actor"));
		SHOP.addUser(new Academic("jasmine26", "123123", "Jasmine Hansen",  "24 Edgware",  "Lawyer"));
		SHOP.addUser(new Academic("michael16", "123123", "Michael Elliott",  "19 Watford", "Teacher"));
		// Add apps
		SHOP.addApp(new App("Scribes", "Free books to read", "87ScribeBooks78", Category.BOOKS));
		SHOP.addApp(new App("FaceSpace", "Social Networking for Students", "FaceSpace", Category.SOCIAL));
		SHOP.addApp(new App("Music Player", "Plays songs from your media library on your phone", "PlayMusic", Category.MUSIC));
		SHOP.addApp(new App("WritePad", "Plain text editor - writing poems, lyrics and essays.", "user039", Category.LIFESTYLE));
		SHOP.addApp(new App("24London", "Recent news around London", "londoner65", Category.NEWS));
		// Add paid apps
		SHOP.addApp(new PaidApp("MakerMusic", "Create tracks from scratch. Change pitch, tempo and sound effects.", "MakerMak0", Category.MUSIC, 10.00));
		SHOP.addApp(new PaidApp("Doodle Fun", "Drawing app for kids.", "Doodle123", Category.GAMES, 10.00));
		SHOP.addApp(new PaidApp("SuperFlashCards", "FlashCards - Be able to create animated flashcards - add images or texts", "FlashCards", Category.EDUCATION, 10.00));
		SHOP.addApp(new PaidApp("Go To Docs", "View, edit and create files.", "Docs102", Category.OTHER, 10.00));
		SHOP.addApp(new PaidApp("WritePad Plus+", "Plain text editor - writing poems, lyrics and essays. 'Paid Version' - Edit font styles, add colour and save to Dropbox/GoogleDrive", "Pad", Category.LIFESTYLE, 10.00));

	}
	
	private void setDefaultSettings() {
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("AppShop");
		frame.setResizable(false);
		frame.setSize(800, 600);
	}
	
	public static void openHomePage() {
		frame.setContentPane(new HomePage());
	}
	
	public static void openSignUpPage() {
		frame.setContentPane(new SignUpPage());
	}
	
	public static void openLogInPage() {
		frame.setContentPane(new LogInPage());
	}
	
	public static void openLogInAdminPage() {
		frame.setContentPane(new LogInAdminPage());
	}
	
	// Admin: Customers
	public static void openManageCustomersPage() {
		frame.setContentPane(new ManageCustomersPage());
	}
	
	public static void openShowCustomerPage(Customer customer) {
		frame.setContentPane(new ShowCustomerPage(customer));
	}
	
	public static void openEditCustomerPage(Customer customer) {
		frame.setContentPane(new EditCustomerPage(customer));
	}
	
	public static void openAddCustomerPage() {
		frame.setContentPane(new AddCustomerPage());
	}
	
	// Admin: Apps
	public static void openManageAppsPage() {
		frame.setContentPane(new ManageAppsPage());
	}
	
	public static void openShowAppPage(App app) {
		frame.setContentPane(new ShowAppPage(app));
	}
	
	public static void openEditAppPage(App app) {
		frame.setContentPane(new EditAppPage(app));
	}
	
	public static void openAddAppPage() {
		frame.setContentPane(new AddAppPage());
	}
	
	// User: Apps
	public static void openListAppsPage() {
		frame.setContentPane(new ListAppsPage());
	}
	
	public static void openAppDetailsPage(App app) {
		frame.setContentPane(new AppDetailsPage(app));
	}
}
