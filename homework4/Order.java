package edu.csula;
public class Order {
	public final int id;
	public final String customerName;
	public final String date;

	public Order (int id, String customerName, String date) {
		this.id = id;
		this.customerName = customerName;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return customerName;
	}

	public String getDate() {
		return date;
	} 

    public String toString() {
        return "id " + id + ", " + "customerName " + customerName + " " + "date " + date;
    } 
}