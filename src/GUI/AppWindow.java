package GUI;
import java.awt.EventQueue;

import javax.swing.JFrame;

import AppShop.Shop;
import GUI.Admin.EditCustomerPage;
import GUI.Admin.ManageCustomersPage;
import GUI.Admin.ShowCustomerPage;


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
	
	public static void openManageCustomersPage() {
		frame.setContentPane(new ManageCustomersPage());
	}
	
	public static void openShowCustomerPage() {
		frame.setContentPane(new ShowCustomerPage());
	}
	
	public static void openEditCustomerPage() {
		frame.setContentPane(new EditCustomerPage());
	}
}
