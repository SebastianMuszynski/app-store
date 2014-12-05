package GUI;
import java.awt.EventQueue;
import javax.swing.JFrame;
import AppShop.*;


public class AppWindow {

	private JFrame frame;
	public static final Shop SHOP = new Shop();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppWindow window = new AppWindow();
					window.frame.setVisible(true);
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
		setDefaultPage();
		
	}
	
	private void setDefaultSettings() {
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("AppShop");
		frame.setResizable(false);
		frame.setSize(800, 600);
	}
	
	private void setDefaultPage() {
		frame.setContentPane(new HomePage());
	}
}
