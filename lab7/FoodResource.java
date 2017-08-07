package edu.csula.jaxrs;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.inject.Singleton;
import javax.ws.rs.PathParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.csula.jaxrs.FoodItem;

@Path("food-resource")
@Singleton
public class FoodResource {
    private List<FoodItem> items = new ArrayList<>(Arrays.asList(new FoodItem(1, "Ramen", "Japanese Noodle Soup", 10.99)));

    @GET
    @Path("items")
    @Produces(MediaType.APPLICATION_JSON)
    public List<FoodItem> getFoodItems() {
        return items;
    }

    @POST
    @Path("items")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean addFoodItem(FoodItem newItem) {
        System.out.println(newItem);
        items.add(newItem);
        System.out.println(items);
        return true;
    }

    @GET
    @Path("foodItem/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public FoodItem getSingleFoodItem(@PathParam("id") int id){
        return items.get(id);
    }

    @GET
    @Path("foodItem/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean updateFoodItem(FoodItem item, @PathParam("id") int id){
        System.out.println(id);
        return true;
    }

    @DELETE
    @Path("delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean deleteFoodItem(FoodItem newItem, @PathParam("id") int id){
        System.out.println("Deleting item id:" + id);
        FoodItemDAO dao = new FoodItemDAO();
        dao.delete(id);
        return true;
    }
}