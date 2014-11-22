
public enum Category {
	NEWS_APP("News app"),
	GAMES_APP("Games app");
	
	// appTitle holds the category String.
	private String appTitle;
	
	private Category(String appTitle){
		this.appTitle = appTitle;
	}
	
	String getCategory(){
		return appTitle;
	}
}
