package GUI;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class LogInPage extends Page {

	private JTextField usernameTxt;
	private JTextField passwordTxt;
	
	/**
	 * Create the panel.
	 */
	public LogInPage() {
		super();
		addFormFields();
		addSendBtn();
	}
	
	private void addFormFields() {
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(65, 156, 112, 15);
		add(lblUsername);

		usernameTxt = new JTextField();
		usernameTxt.setColumns(10);
		usernameTxt.setBounds(195, 154, 114, 19);
		add(usernameTxt);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(65, 183, 112, 15);
		add(lblPassword);
		
		passwordTxt = new JTextField();
		passwordTxt.setColumns(10);
		passwordTxt.setBounds(195, 181, 114, 19);
		add(passwordTxt);
	}
	
	private void addSendBtn() {
		Button button_1 = new Button("Send");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logInUser();
				AppWindow.openHomePage();
			}
		});
		button_1.setBounds(195, 345, 167, 29);
		add(button_1);
	}
	
	private void logInUser() {
		/**
		 * TODO: implement logging user in
		 */
	}
}
