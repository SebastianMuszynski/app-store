package AppShop;

public enum Category {
	NEWS		("news"),
	EDUCATION	("education"),
	GAMES		("games"),
	SOCIAL 		("social networking"),
	TRAVEL		("travel"),
	MUSIC		("music"),
	BOOKS		("books"),
	FILMS		("films"),
	LIFESTYLE	("lifestyle"),
	OTHER		("other");
	
	private final String name;
	
	Category(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}	
}
