package AppShop;

public abstract class User {
	protected String username;
	private String password;
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public boolean checkPassword(String password) {
		return this.password.equals(password);
	}

}
