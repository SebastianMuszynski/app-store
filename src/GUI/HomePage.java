package GUI;

import java.awt.Button;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import AppShop.User;

@SuppressWarnings("serial")
public class HomePage extends Page {

	/**
	 * Create the panel.
	 */
	public HomePage() {
		super();
		addAppsNumberInfo();
		addUsersNumberInfo();
		if(AppWindow.SHOP.isAdminLoggedIn()) {
			addLogOutBtn();
			addUserLoggedInInfo(AppWindow.SHOP.getCurrentUser());
			addManageCustomersBtn();
		} else if(AppWindow.SHOP.isUserLoggedIn()) {
			addLogOutBtn();
			addUserLoggedInInfo(AppWindow.SHOP.getCurrentUser());
		} else {
			addAdminLoginBtn();
			addLoginBtn();
			addSignUpBtn();
		}
	}

	private void addAdminLoginBtn() {
		Button button = new Button("Log in as an admin");
		button.setBounds(623, 10, 167, 40);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppWindow.openLogInAdminPage();
			}
		});
		add(button);
	}
	
	private void addManageCustomersBtn() {
		Button button = new Button("Customers");
		button.setBounds(216, 469, 150, 50);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppWindow.openManageCustomersPage();
			}
		});
		add(button);
	}
	
	private void addLoginBtn() {
		Button button_1 = new Button("Log in");
		button_1.setBounds(216, 469, 150, 50);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppWindow.openLogInPage();
			}
		});
		add(button_1);
	}
	
	private void addLogOutBtn() {
		Button button = new Button("Log out");
		button.setBounds(623, 10, 167, 40);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppWindow.SHOP.setCurrentUser(null);
				AppWindow.openHomePage();
			}
		});
		add(button);
	}
	
	private void addSignUpBtn() {
		Button button_2 = new Button("Sign up");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppWindow.openSignUpPage();
			}
		});
		button_2.setBounds(485, 469, 150, 50);
		add(button_2);
	}
	
	private void addAppsNumberInfo() {
		Label label = new Label("Total number of apps: " + getShop().appsNumber());
		label.setBounds(90, 175, 200, 21);
		add(label);
		
		Label label_1 = new Label("– FREE apps: " + getShop().freeAppsNumber());
		label_1.setBounds(121, 203, 131, 21);
		add(label_1);
		
		Label label_2 = new Label("– PAID apps: " + getShop().paidAppsNumber());
		label_2.setBounds(121, 230, 119, 21);
		add(label_2);
	}
	
	private void addUsersNumberInfo() {
		Label label = new Label("Total number of customers: " + getShop().customersNumber());
		label.setBounds(90, 279, 200, 21);
		add(label);
		
		Label label_2 = new Label("– normal customers: " + getShop().normalCustomersNumber());
		label_2.setBounds(121, 306, 169, 21);
		add(label_2);
		
		Label label_1 = new Label("– students: " + getShop().studentsNumber());
		label_1.setBounds(121, 333, 131, 21);
		add(label_1);
		
		Label label_3 = new Label("– academics: " + getShop().academicsNumber());
		label_3.setBounds(121, 360, 119, 21);
		add(label_3);
	}
	
	private void addUserLoggedInInfo(User user) {
		JLabel lblCurrentlyLoggedIn = new JLabel("Currently logged in as: " + user.getUsername());
		lblCurrentlyLoggedIn.setBounds(12, 12, 382, 15);
		add(lblCurrentlyLoggedIn);
	}
}
