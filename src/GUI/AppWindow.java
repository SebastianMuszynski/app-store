package GUI;
import java.awt.EventQueue;

import javax.swing.JFrame;

import AppShop.App;
import AppShop.Category;
import AppShop.Customer;
import AppShop.PaidApp;
import AppShop.Shop;
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
		App app = new App("Flappy Bird", "Flapping bird game.", "Dev Name", Category.NEWS);
		PaidApp paidApp = new PaidApp("Flappy Bird", "Flapping bird game.", "Dev Name", Category.SOCIAL, 12.50);
		SHOP.addApp(app);
		SHOP.addApp(paidApp);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		setDefaultSettings();
		openHomePage();
		frame.setVisible(true);
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
