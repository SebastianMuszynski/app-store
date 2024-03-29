package AppShop;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
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
	
	public boolean isAdminLoggedIn() {
		return currentUser != null && currentUser instanceof Admin;
	}
	
	public boolean isUserLoggedIn() {
		return currentUser != null && !(currentUser instanceof Admin);
	}
	
	/**
	 * @return total number of apps
	 */
	public int appsNumber() {
		return apps.size();
	}
	
	public int numberOfPurchasedApps() {
		int number = 0;
		for(Customer customer : getCustomers())
			number += customer.paidAppsNumber();
		return number;
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
	
	public ArrayList<Customer> getCustomers() {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		for(User user : users)
			if(user instanceof Customer)
				customers.add((Customer) user);
		return customers;
	}
	
	public ArrayList<App> getApps() {
		return apps;
	}
	
	public ArrayList<App> getAppsByCategoryName(String category) {
		ArrayList<App> selectedApps = new ArrayList<App>();
		for(App app : apps)
			if(app.getCategoryName().equals(category))
				selectedApps.add(app);
		return selectedApps;
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
			if(currentApp.getName().equals(name)) 
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
			try {
				File file = new File("data/apps/" + app.getName() + ".app");
				if(file.delete()){
					apps.remove(appIndex);
				}
			}catch (Exception e){
				e.printStackTrace();
			}
//			apps.remove(appIndex);
	}
	
	public void deleteAppByName(String appName) {
		boolean foundApp = false;
		for(int i = 0; i < apps.size() && !foundApp; i++)
			if(apps.get(i).getName().equals(appName)) {
				try {
					File file = new File("data/apps/" + apps.get(i).getName() + ".app");
					if(file.delete()){
						apps.remove(i);
					}
					
					foundApp = true;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	}
	
	/**
	 * It deletes the given user from the shop.
	 * @param user – the user we want to delete.
	 */
	public void deleteUser(User user) {
		Integer userIndex = findUserIndex(user);
		if(userIndex != null) {
			try {
				File file = new File("data/customers/" + users.get(userIndex).getUsername() + ".apu");
				file.delete();
				users.remove(userIndex);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void deleteUserByUsername(String username) {
		boolean foundUser = false;
		for(int i = 0; i < users.size() && !foundUser; i++)
			if(users.get(i).getUsername().equals(username)) {
				try {
					File file = new File("data/customers/" + users.get(i).getUsername() + ".apu");
					file.delete();
					users.remove(i);
					foundUser = true;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	}
	
	/**
	 * @param app – the app we are looking for.
	 * @return the index of given app, null if the app does not exist.
	 */
	public Integer findAppIndex(App app) {
		Integer appIndex = null;
		for(int i = 0; i < apps.size() && appIndex == null; i++)
			if(apps.get(i).getName().equals(app.getName()))
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
			if(user.getUsername().equals(users.get(i).getUsername())) 
				userIndex = i;
		return userIndex;
	}

}
