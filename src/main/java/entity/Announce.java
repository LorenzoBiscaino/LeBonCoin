package entity;

public class Announce {
	private int id;
	private String category;
	private String announceTitle;
	private String region;
	private String description;
	private String state;
	private String photos;
	private int userId;
	private float price;
	
	// Constructor with id
	public Announce(int id, String category, String announceTitle, String region, String description, String state,
			String photos, int userId, float price) {
		super();
		this.id = id;
		this.category = category;
		this.announceTitle = announceTitle;
		this.region = region;
		this.description = description;
		this.state = state;
		this.photos = photos;
		this.userId = userId;
		this.price = price;
	}

	// Constructor without id	
	public Announce(String category, String announceTitle, String region, String description, String state,
			String photos, int userId, float price) {
		super();
		this.category = category;
		this.announceTitle = announceTitle;
		this.region = region;
		this.description = description;
		this.state = state;
		this.photos = photos;
		this.userId = userId;
		this.price = price;
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

	
	//getter setter announceTitle
	public String getAnnounceTitle() {
		return announceTitle;
	}

	public void setAnnounceTitle(String announceTitle) {
		this.announceTitle = announceTitle;
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


	//getter setter userId
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}


	//getter setter price
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
}
