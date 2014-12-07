package GUI;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import AppShop.Shop;

@SuppressWarnings("serial")
public abstract class Page extends JPanel {
	
	/**
	 * Create the panel.
	 */
	public Page() {
		setLayout(null);
		setBounds(100, 100, 450, 300);
		setSize(800, 600);
		setLocation(0, 0);
		addHomePageBtn();
	}
	
	public Shop getShop() {
		return AppWindow.SHOP;
	}
	
	private void addHomePageBtn() {
		Button btnHomepage = new Button("AppShop");
		btnHomepage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppWindow.openHomePage();
			}
		});
		btnHomepage.setBounds(330, 66, 140, 42);
		add(btnHomepage);
	}

}
