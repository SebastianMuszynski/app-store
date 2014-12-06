package GUI;

import AppShop.Admin;
import AppShop.User;

@SuppressWarnings("serial")
public class LogInAdminPage extends LogInPage {

	/**
	 * Create the panel.
	 */
	public LogInAdminPage() {
		super();
	}
	
	protected void logInUser() {
		String username = usernameTxt.getText();
		String password = passwordTxt.getText();
		User user = AppWindow.SHOP.findUserByUsername(username);
		if(user != null && user instanceof Admin && user.checkPassword(password)) {
			AppWindow.SHOP.setCurrentUser(user);
			AppWindow.openHomePage();
		} else 
			showErrorMsg();
	}

}
