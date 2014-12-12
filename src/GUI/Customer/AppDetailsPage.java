package GUI.Customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import AppShop.App;
import AppShop.Customer;
import AppShop.PaidApp;
import GUI.AppWindow;
import GUI.Page;

@SuppressWarnings("serial")
public class AppDetailsPage extends Page {
	private App app;
	
	public AppDetailsPage(App app) {
		super();
		this.app = app;
		
		JLabel lblNewLabel = new JLabel("Name: " + app.getName());
		lblNewLabel.setBounds(88, 243, 300, 15);
		add(lblNewLabel);
		
		JLabel lblDescription = new JLabel("Description: " + app.getDescription());
		lblDescription.setBounds(88, 270, 300, 15);
		add(lblDescription);
		
		JLabel lblDeveloperName = new JLabel("Developer name: " + app.getDeveloperName());
		lblDeveloperName.setBounds(88, 297, 300, 15);
		add(lblDeveloperName);
		
		String type = isPaidApp() ? "PAID" : "FREE";
		JLabel appTypeLabel = new JLabel("Type of the app: " + type);
		appTypeLabel.setBounds(89, 176, 300, 15);
		add(appTypeLabel);
		
		JLabel categoryLabel = new JLabel("Category: " + app.getCategoryName());
		categoryLabel.setBounds(88, 212, 300, 15);
		add(categoryLabel);
		
		if(isPaidApp()) {
			JLabel costLabel = new JLabel("Cost: " + app.getCost());
			costLabel.setBounds(88, 324, 300, 15);
			add(costLabel);
		}
		
		addDownloadButtons();
		addBackBtn();
	}
	
	private void addBackBtn() {
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppWindow.openHomePage();
			}
		});
		btnBack.setBounds(345, 522, 110, 25);
		add(btnBack);
	}
	
	private boolean isPaidApp() {
		return app instanceof PaidApp;
	}
	
	private void addDownloadButtons() {
		JButton btnBuyAndDownload = new JButton("Buy and download");
		btnBuyAndDownload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((Customer) AppWindow.SHOP.getCurrentUser()).addApp(app);
			}
		});
		btnBuyAndDownload.setBounds(526, 283, 190, 25);
		add(btnBuyAndDownload);
		
		JButton btnDownload = new JButton("Download");
		btnDownload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((Customer) AppWindow.SHOP.getCurrentUser()).addApp(app);
			}
		});
		btnDownload.setBounds(526, 283, 190, 25);
		add(btnDownload);
	}

}
