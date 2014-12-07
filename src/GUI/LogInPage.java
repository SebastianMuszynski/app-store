package GUI;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

import AppShop.Admin;
import AppShop.User;

@SuppressWarnings("serial")
public class LogInPage extends Page {

	protected JTextField usernameTxt;
	protected JTextField passwordTxt;
	private JLabel lblErrorMsg;
	
	/**
	 * Create the panel.
	 */
	public LogInPage() {
		super();
		addFormFields();
		addSendBtn();
		addErrorMsg();
		hideErrorMsg();
	}
	
	private void addFormFields() {
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(205, 281, 112, 15);
		add(lblUsername);

		usernameTxt = new JTextField();
		usernameTxt.setColumns(10);
		usernameTxt.setBounds(335, 279, 167, 19);
		add(usernameTxt);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(205, 308, 112, 15);
		add(lblPassword);
		
		passwordTxt = new JTextField();
		passwordTxt.setColumns(10);
		passwordTxt.setBounds(335, 306, 167, 19);
		add(passwordTxt);
	}
	
	private void addSendBtn() {
		Button button_1 = new Button("Send");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hideErrorMsg();
				logInUser();
			}
		});
		button_1.setBounds(335, 331, 167, 29);
		add(button_1);
	}
	
	protected void logInUser() {
		String username = usernameTxt.getText();
		String password = passwordTxt.getText();
		User user = AppWindow.SHOP.findUserByUsername(username);
		if(user != null && user.checkPassword(password) && !(user instanceof Admin)) {
			AppWindow.SHOP.setCurrentUser(user);
			AppWindow.openHomePage();
		} else 
			showErrorMsg();
	}
	
	private void addErrorMsg() {
		lblErrorMsg = new JLabel("We are sorry, but there is no user with provided username and password.");
		lblErrorMsg.setBounds(147, 221, 641, 15);
		add(lblErrorMsg);
	}
	
	protected void showErrorMsg() {
		lblErrorMsg.setVisible(true);
	}
	
	private void hideErrorMsg() {
		lblErrorMsg.setVisible(false);
	}
}
