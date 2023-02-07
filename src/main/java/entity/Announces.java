package entity;

public class Announces {
	private int id;
	private String category;
	private String announce_title;
	private String region;
	private String description;
	private String state;
	private String photos;
	private int user_id;
	
	// Constructor with id
	public Announces(int id, String category, String announce_title, String region, String description, String state,
			String photos, int user_id) {
		super();
		this.id = id;
		this.category = category;
		this.announce_title = announce_title;
		this.region = region;
		this.description = description;
		this.state = state;
		this.photos = photos;
		this.user_id = user_id;
	}

	// Constructor without id
	public Announces(String category, String announce_title, String region, String description, String state,
			String photos, int user_id) {
		super();
		this.category = category;
		this.announce_title = announce_title;
		this.region = region;
		this.description = description;
		this.state = state;
		this.photos = photos;
		this.user_id = user_id;
	}
	
	//getter setter id

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	//getter setter category
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	//getter setter announce_title
	public String getAnnounce_title() {
		return announce_title;
	}

	public void setAnnounce_title(String announce_title) {
		this.announce_title = announce_title;
	}

	//getter setter region
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	//getter setter description
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	//getter setter state
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	//getter setter photos
	public String getPhotos() {
		return photos;
	}

	public void setPhotos(String photos) {
		this.photos = photos;
	}


	//getter setter user_id
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
}
