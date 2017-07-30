package edu.csula;
public class FoodItem {
	public final int id;
	public final String foodName;
	public final String description;
    public final Double price;

	public FoodItem (int id, String foodName, String description, Double price) {
		this.id = id;
		this.foodName = foodName;
		this.description = description;
        this.price = price;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return foodName;
	}

	public String getDescription() {
		return description;
	}

    public Double getPrice(){
        return price;
    }

    public String toString() {
        return "id " + id + " " + "foodName " + foodName + " " + "description " + description + " " + 
                "price " + price;
    }  
}