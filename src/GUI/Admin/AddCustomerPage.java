package GUI.Admin;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.AppWindow;
import GUI.SignUpPage;

@SuppressWarnings("serial")
public class AddCustomerPage extends SignUpPage {

	/**
	 * Create the panel.
	 */
	public AddCustomerPage() {
		super();
	}
	
	protected void addSendBtn() {
		Button button = new Button("Add customer");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createUser();
				AppWindow.openManageCustomersPage();
			}
		});
		button.setBounds(195, 345, 167, 29);
		add(button);
	}
}
