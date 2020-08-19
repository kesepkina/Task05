package by.itacademy.mhl.bean;

public class Note {
	private int id;
	private String[] categories;
	private String name;
	private String[] authors;

	public Note(int id, String[] categories, String name, String[] authors) {
		super();
		this.id = id;
		this.categories = categories;
		this.name = name;
		this.authors = authors;
	}

	public String[] getCategories() {
		return categories;
	}

	public void setCategories(String[] categories) {
		this.categories = categories;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getAuthors() {
		return authors;
	}

	public void setAuthors(String[] authors) {
		this.authors = authors;
	}

	public int getId() {
		return id;
	}

}
