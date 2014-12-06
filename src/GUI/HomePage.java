package GUI;

import java.awt.Button;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class HomePage extends Page {

	/**
	 * Create the panel.
	 */
	public HomePage() {
		super();
		addAdminLoginBtn();
		addLoginBtn();
		addSignUpBtn();
		addAppsNumberInfo();
		addUsersNumberInfo();
	}

	private void addAdminLoginBtn() {
		Button button = new Button("Log in as an admin");
		button.setBounds(623, 10, 167, 40);
		add(button);
	}
	
	private void addLoginBtn() {
		Button button_1 = new Button("Log in");
		button_1.setBounds(216, 469, 150, 50);
		add(button_1);
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
		Label label = new Label("Total number of users: " + getShop().usersNumber());
		label.setBounds(90, 279, 200, 21);
		add(label);
		
		Label label_2 = new Label("– normal customers: " + getShop().customersNumber());
		label_2.setBounds(121, 306, 169, 21);
		add(label_2);
		
		Label label_1 = new Label("– students: " + getShop().studentsNumber());
		label_1.setBounds(121, 333, 131, 21);
		add(label_1);
		
		Label label_3 = new Label("– academics: " + getShop().academicsNumber());
		label_3.setBounds(121, 360, 119, 21);
		add(label_3);
	}
}
