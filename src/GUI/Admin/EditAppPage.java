package GUI.Admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import AppShop.App;
import AppShop.Category;
import AppShop.PaidApp;
import AppShop.Serialiser;
import GUI.AppWindow;
import GUI.Page;

@SuppressWarnings("serial")
public class EditAppPage extends Page {
	private JTextField nameTxt;
	private JTextField descriptionTxt;
	private JTextField devNameTxt;
	private JTextField costTxt;
	private JButton btnEditApp;
	private JLabel appTypeLabel;
	private JComboBox<String> appType;
	private JComboBox<Category> appCategory;
	private JLabel categoryLabel;
	private JLabel costLabel;
	private JButton backBtn;
	private App currentApp;

	public EditAppPage(App app) {
		super();
		this.currentApp = app;
		addAppInfo();
		addEditBtn();
		addBackBtn();
	}
	
	private void addAppInfo() {
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(88, 243, 100, 15);
		add(lblNewLabel);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setBounds(88, 270, 100, 15);
		add(lblDescription);
		
		JLabel lblDeveloperName = new JLabel("Developer name:");
		lblDeveloperName.setBounds(88, 297, 160, 15);
		add(lblDeveloperName);
		
		costLabel = new JLabel("Cost:");
		costLabel.setBounds(88, 324, 160, 15);
		add(costLabel);
		
		nameTxt = new JTextField(currentApp.getName());
		nameTxt.setBounds(233, 241, 170, 19);
		add(nameTxt);
		nameTxt.setColumns(10);
		
		descriptionTxt = new JTextField(currentApp.getDescription());
		descriptionTxt.setColumns(10);
		descriptionTxt.setBounds(233, 270, 170, 19);
		add(descriptionTxt);
		
		devNameTxt = new JTextField(currentApp.getDeveloperName());
		devNameTxt.setColumns(10);
		devNameTxt.setBounds(233, 295, 170, 19);
		add(devNameTxt);
		
		costTxt = new JTextField("" + currentApp.getCost());
		costTxt.setColumns(10);
		costTxt.setBounds(233, 322, 170, 19);
		add(costTxt);
		
		appTypeLabel = new JLabel("Type of the app:");
		appTypeLabel.setBounds(89, 176, 127, 15);
		add(appTypeLabel);
		
		appType = new JComboBox<String>();
		appType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCostFieldVisibility(isPaidApp());
			}
		});
		appType.setModel(new DefaultComboBoxModel<String>(new String[] {"FREE", "PAID"}));
		appType.setBounds(234, 171, 100, 24);
		add(appType);
		
		categoryLabel = new JLabel("Category:");
		categoryLabel.setBounds(88, 212, 137, 15);
		add(categoryLabel);
		
		appCategory = new JComboBox<Category>();
		appCategory.setModel(new DefaultComboBoxModel<Category>(Category.values()));
		appCategory.setBounds(233, 207, 170, 24);
		add(appCategory);
	}
	
	private void addEditBtn() {
		btnEditApp = new JButton("Edit app");
		btnEditApp.setBounds(260, 353, 117, 25);
		btnEditApp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editApp();
				AppWindow.openManageAppsPage();
			}
		});
		add(btnEditApp);
	}
	
	private void editApp() {
		String name = nameTxt.getText();
		String description = descriptionTxt.getText();
		String developerName = devNameTxt.getText();
		Category category = (Category) appCategory.getSelectedItem();
		
		if(isPaidApp()) {
			// Selected type of app: PAID
			double cost = Double.parseDouble(costTxt.getText());
			if(currentApp instanceof PaidApp) {
				// ... and previous type of app was also PAID
				currentApp.setName(name);
				currentApp.setDescription(description);
				currentApp.setDeveloperName(developerName);
				currentApp.setCategory(category);
				currentApp.setCost(cost);
			} else {
				// ... but previous type of app was FREE
				AppWindow.SHOP.deleteAppByName(currentApp.getName());
				PaidApp newPaidApp = new PaidApp(name, description, developerName, category, cost);
				AppWindow.SHOP.addApp(newPaidApp);
				Serialiser.serialise(newPaidApp, "data/apps/" + newPaidApp.getName() +".app");
			}
		} else {
			// Selected type of app: FREE
			if(currentApp instanceof PaidApp) {
				// ... but previous type of app was PAID
				AppWindow.SHOP.deleteAppByName(currentApp.getName());
				App newFreeApp = new App(name, description, developerName, category);
				AppWindow.SHOP.addApp(newFreeApp);
				Serialiser.serialise(newFreeApp, "data/apps/" + newFreeApp.getName() +".app");
			} else {
				// ... and previous type of app was also FREE
				currentApp.setName(name);
				currentApp.setDescription(description);
				currentApp.setDeveloperName(developerName);
				currentApp.setCategory(category);
			}
		}
	}
	
	private boolean isPaidApp() {
		return appType.getSelectedItem().toString().equals("PAID");
	}
	
	private void setCostFieldVisibility(Boolean showCostField) {
		costLabel.setVisible(showCostField);
		costTxt.setVisible(showCostField);
	}
	
	private void addBackBtn() {
		backBtn = new JButton("Back");
		backBtn.setBounds(12, 563, 85, 25);
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppWindow.openManageAppsPage();
			}
		});
		add(backBtn);
	}
}
