package GUI;
import java.awt.EventQueue;

import javax.swing.JFrame;

import AppShop.Shop;


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
}
