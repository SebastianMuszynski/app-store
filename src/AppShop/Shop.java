package AppShop;
import java.util.ArrayList;

public class Shop {
	ArrayList<App> apps;
	ArrayList<User> users;
	private User currentUser;
	
	public Shop() {
		apps = new ArrayList<App>();
		users = new ArrayList<User>();
		users.add(new Admin("admin", "123456"));
		currentUser = null;
	}
	
	public User findUserByUsername(String username) {
		User wantedUser = null;
		for(int i = 0; i < users.size() && wantedUser == null; i++) {
			User user = users.get(i);
			if(user.getUsername().equals(username))
				wantedUser = user;
		}
		return wantedUser;
	}
	
	public User getCurrentUser() {
		return currentUser;
	}
	
	public void setCurrentUser(User user) {
		currentUser = user;
	}
	
	/**
	 * @return total number of apps
	 */
	public int appsNumber() {
		return apps.size();
	}
	
	/**
	 * @return number of apps used as a free trial. 
	 */
	public int freeAppsNumber() {
		return appsNumber() - paidAppsNumber();
	}
	
	/**
	 * @return number of purchased apps. 
	 */
	public int paidAppsNumber() {
		int number = 0;
		for(int i = 0; i < appsNumber(); i++)
			if(apps.get(i) instanceof PaidApp)
				number++;
		return number;
	}
	
	/**
	 * @return total number of users
	 */
	public int usersNumber() {
		return users.size();
	}
	
	public int customersNumber() {
		int number = 0;
		for(User user : users)
			if(user instanceof Customer)
				number++;
		return number;
	}
	
	public int normalCustomersNumber() {
		return customersNumber() - studentsNumber() - academicsNumber();
	}
	
	public int studentsNumber() {
		int number = 0;
		for(User user : users)
			if(user instanceof Student)
				number++;
		return number;
	}
	
	public int academicsNumber() {
		int number = 0;
		for(User user : users)
			if(user instanceof Academic)
				number++;
		return number;
	}
	
	/**
	 * It adds new app to the shop.
	 * @param app – newly created app.
	 */
	public void addApp(App app) {
		apps.add(app);
	}
	
	/**
	 * It adds new user to the shop.
	 * @param user – newly created user.
	 */
	public void addUser(User user) {
		users.add(user);
	}
	
	/**
	 * It lists all the apps from the shop.
	 * TODO: implement toString() method in the App
	 */
	public void listApps() {
		for(int i = 0; i < apps.size(); i++)
			System.out.println(apps.get(i));
	}
	
	/**
	 * It lists all the users from the shop.
	 */
	public void listUsers() {
		for(int i = 0; i < users.size(); i++)
			System.out.println(users.get(i));
	}
	
	/**
	 * It looks for the app by given app's name.
	 * @param name – name of the app we want to find.
	 * @return the app if it has been found, otherwise null.
	 */
	public App findAppByName(String name) {
		App app = null;
		for(int i = 0; i < apps.size() && app == null; i++) {
			App currentApp = apps.get(i);
			if(name == currentApp.getName()) 
				app = currentApp;
		}
		return app;
	}
	
	/**
	 * It deletes the given app from the shop.
	 * @param app – the app we want to delete.
	 */
	public void deleteApp(App app) {
		Integer appIndex = findAppIndex(app);
		if(appIndex != null)
			apps.remove(appIndex);
	}
	
	/**
	 * It deletes the given user from the shop.
	 * @param user – the user we want to delete.
	 */
	public void deleteUser(User user) {
		Integer userIndex = findUserIndex(user);
		if(userIndex != null)
			users.remove(userIndex);
	}
	
	/**
	 * @param app – the app we are looking for.
	 * @return the index of given app, null if the app does not exist.
	 */
	public Integer findAppIndex(App app) {
		Integer appIndex = null;
		for(int i = 0; i < apps.size() && appIndex == null; i++)
			if(app == apps.get(i)) 
				appIndex = i;
		return appIndex;
	}
	
	/**
	 * @param user – the user we are looking for.
	 * @return the index of given user, null if the user does not exist.
	 */
	public Integer findUserIndex(User user) {
		Integer userIndex = null;
		for(int i = 0; i < users.size() && userIndex == null; i++)
			if(user == users.get(i)) 
				userIndex = i;
		return userIndex;
	}

}
