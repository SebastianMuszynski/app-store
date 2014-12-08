package GUI.Admin;

import javax.swing.JLabel;

import AppShop.App;
import AppShop.PaidApp;
import GUI.Page;

@SuppressWarnings("serial")
public class ShowAppPage extends Page {
	private App app;
	
	/**
	 * Create the panel.
	 */
	public ShowAppPage(App app) {
		super();
		this.app = app;
		addAppInfo();
	}

	private void addAppInfo() {
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
	}
	
	private boolean isPaidApp() {
		return app instanceof PaidApp;
	}
}
