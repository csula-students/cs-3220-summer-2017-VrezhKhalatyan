import java.util.ArrayList;


public class OrderStatus {
    private ArrayList foodItems = new ArrayList();
    private double orderTotl;
  
    public int getFoodCount() {
        return foodItems.size();
    }
  
    public void deleteFoodItem(String index) {
        int idx = 0;
        try {
            idx= Integer.parseInt(index);
            foodItems.remove(idx - 1);
            orderTotal();
        } catch(NumberFormatException nf) {
        System.out.println("Error while deleting cart item: "+nf.getMessage());
        nf.printStackTrace();
        }
    }
  
    public void alterOrderStatus(String index, String quantities) {
        double totalCost = 0.0;
        double price = 0.0;
        int quantity = 0;
        int indexItem = 0;
        FoodItem createFood = null;
        try {
            indexItem = Integer.parseInt(index);
            quantity = Integer.parseInt(quantities);
            if(quantity>0) {
                createFood = (FoodItem)foodItems.get(indexItem-1);
                price = createFood.getPrice();
                totalCost = price * quantity;
                createFood.setQuantity(quantity);
                createFood.setTotalCost(totalCost);
                orderTotal();
            }
        } catch (NumberFormatException nf) {
        System.out.println("Error while updating cart: "+nf.getMessage());
        nf.printStackTrace();
        }

    }
  
    public void addingFood(String model, String description,
        String units, String quantities) {
        double totalCost = 0.0;
        double price = 0.0;
        int quantity = 0;
        FoodItem foodItm = new FoodItem();
        try {
            price = Double.parseDouble(units);
            quantity = Integer.parseInt(quantities);
            if(quantity>0) {
                totalCost = price*quantity;
                foodItm.setId(model);
                foodItm.setDescription(description);
                foodItm.setPrice(price);
                foodItm.setQuantity(quantity);
                foodItm.setTotalCost(totalCost);
                foodItems.add(foodItm);
                orderTotal();
            }
  
        } catch (NumberFormatException nf) {
        System.out.println("Error while parsing from String to primitive types: "+nf.getMessage());
        nf.printStackTrace();
        }
    }
  
    public void addingFood(FoodItem foodItm) {
        foodItems.add(foodItm);
    }
  
    public FoodItem getStatus(int indexItem) {
        FoodItem foodItm = null;
        if(foodItems.size()>indexItem) {
            foodItm = (FoodItem) foodItems.get(indexItem);
        }
        return foodItm;
    }
  
    public ArrayList getStatuses() {
        return foodItems;
    }

    public void setFoodItems(ArrayList foodItems) {
        this.foodItems = foodItems;
    }

    public double getOrderCount() {
        return orderTotl;
    }

    public void setOrderTotal(double orderTotl) {
        this.orderTotl = orderTotl;
    }
  
    protected void orderTotal() {
        double total = 0;
        for(int i=0;i<foodItems.size();i++) {
            FoodItem foodItm = (FoodItem) foodItems.get(i);
            total+=foodItm.gettotalCost();
  
        }
        setOrderTotal(total);
    }

}