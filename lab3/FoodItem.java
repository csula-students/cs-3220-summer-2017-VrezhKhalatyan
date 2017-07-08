public class FoodItem {
	public final int id;
	public final String name;
	public final String description;

	public FoodItem (int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
}