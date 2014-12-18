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
public class AddAppPage extends Page {
	private JTextField nameTxt;
	private JTextField descriptionTxt;
	private JTextField devNameTxt;
	private JTextField costTxt;
	private JButton btnCreateApp;
	private JLabel appTypeLabel;
	private JComboBox<String> appType;
	private JComboBox<Category> appCategory;
	private JLabel categoryLabel;
	private JLabel costLabel;
	private JButton backBtn;

	public AddAppPage() {
		super();
		addFormFields();
		setCostFieldVisibility(false);
		addCreateBtn();
		addBackBtn();
	}
	
	private void addFormFields() {
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
		
		nameTxt = new JTextField();
		nameTxt.setBounds(233, 241, 170, 19);
		add(nameTxt);
		nameTxt.setColumns(10);
		
		descriptionTxt = new JTextField();
		descriptionTxt.setColumns(10);
		descriptionTxt.setBounds(233, 270, 170, 19);
		add(descriptionTxt);
		
		devNameTxt = new JTextField();
		devNameTxt.setColumns(10);
		devNameTxt.setBounds(233, 295, 170, 19);
		add(devNameTxt);
		
		costTxt = new JTextField();
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
	
	private void addCreateBtn() {
		btnCreateApp = new JButton("Create app");
		btnCreateApp.setBounds(260, 353, 117, 25);
		btnCreateApp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createApp();
				AppWindow.openManageAppsPage();
			}
		});
		add(btnCreateApp);
	}
	
	private App createApp() {
		App app = null;
		String name = nameTxt.getText();
		String description = descriptionTxt.getText();
		String developerName = devNameTxt.getText();
		Category category = (Category) appCategory.getSelectedItem();
		
		if(isPaidApp()) {
			double cost = Double.parseDouble(costTxt.getText());
			app = new PaidApp(name, description, developerName, category, cost);
		} else
			app = new App(name, description, developerName, category);
		
		Serialiser.serialise(app, "data/apps/" + app.getName() +".app");
		AppWindow.SHOP.addApp(app);
		return app;
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
