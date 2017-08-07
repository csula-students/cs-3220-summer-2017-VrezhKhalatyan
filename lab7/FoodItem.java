package edu.csula.jaxrs;

public class FoodItem {
    private int id;
    private String foodName;
    private String description;
    private double price;

    public FoodItem () {
        this.id = 0;
        this.foodName = "";
        this.description = "";
        this.price = 0.0;
    }

    public FoodItem(int id, String foodName, String description, double price) {
        this.id = id;
        this.foodName = foodName;
        this.description = description;
        this.price = price;
    }

    public int getId(){
        return id;
    }

    public FoodItem setId(int id){
        this.id = id;
        return this;
    }

    public String getFoodName() {
        return foodName;
    }

    public FoodItem setFoodName(String foodName) {
        this.foodName = foodName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public FoodItem setDescription(String description) {
        this.description = description;
        return this;
    }

    public double getPrice(){
        return price;
    }

    public FoodItem setPrice(double price){
        this.price = price;
        return this;
    }
}