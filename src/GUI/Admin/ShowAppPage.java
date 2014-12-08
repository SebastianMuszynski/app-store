package GUI.Admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import AppShop.App;
import AppShop.PaidApp;
import GUI.AppWindow;
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
		addEditAppBtn();
		addRemoveAppBtn();
		addBackBtn();
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
	
	private void addEditAppBtn() {
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(514, 200, 150, 25);
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppWindow.openEditAppPage(app);
			}
		});
		add(btnEdit);
	}
	
	private void addRemoveAppBtn() {
		JButton btnRemove = new JButton("Remove");
		btnRemove.setBounds(514, 237, 150, 25);
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppWindow.SHOP.deleteAppByName(app.getName());
				AppWindow.openManageAppsPage();
			}
		});
		add(btnRemove);
	}
	
	private void addBackBtn() {
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppWindow.openManageAppsPage();
			}
		});
		btnBack.setBounds(116, 379, 81, 25);
		add(btnBack);
	}
	
	private boolean isPaidApp() {
		return app instanceof PaidApp;
	}
}
