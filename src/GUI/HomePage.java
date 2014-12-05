package GUI;

import java.awt.Button;

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
		button_2.setBounds(485, 469, 150, 50);
		add(button_2);
	}
}
