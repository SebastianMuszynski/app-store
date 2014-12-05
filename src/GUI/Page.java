package GUI;

import java.awt.Font;
import java.awt.Label;

import javax.swing.JPanel;

import AppShop.Shop;

@SuppressWarnings("serial")
public abstract class Page extends JPanel {
	
	/**
	 * Create the panel.
	 */
	public Page() {
		setBounds(100, 100, 450, 300);
		setSize(800, 600);
		setLayout(null);
		addTitle("AppShop");
	}
	
	private void addTitle(String title) {
		Label label = new Label(title);
		label.setFont(new Font("Dialog", Font.PLAIN, 20));
		label.setAlignment(Label.CENTER);
		label.setBounds(331, 43, 129, 69);
		add(label);
	}
	
	public Shop getShop() {
		return AppWindow.SHOP;
	}

}
