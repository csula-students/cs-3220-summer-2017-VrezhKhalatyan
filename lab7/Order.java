package edu.csula.jaxrs;

public class Order {
    private int id;
    private String name;
    private String created;

    public Order () {
        this.id = 0;
        this.name = "";
        this.created = "";
    }

    public Order (int id, String name, String created) {
        this.id = id;
        this.name = name;
        this.created = created;
    }

    public int getId(){
        return id;
    }

    public Order setId(int id){
        this.id = id;
        return this;
    }

    public String getOrderName() {
        return name;
    }

    public Order setOrderName(String name){
        this.name = name;
        return this;
    }

    public String getDateCreated(){
        return created;
    }

    public Order setDate(){
        this.created = created;
        return this;
    }
}