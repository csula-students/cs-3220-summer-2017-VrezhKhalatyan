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

import edu.csula.jaxrs.Order;

@Path("order-resource")
@Singleton
public class OrderResource {
    public static List<Order> orders = new ArrayList<>(Arrays.asList(new Order(1, "Vrezh", "08-06-2017")));

    @GET
    @Path("orders")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Order> getOrders() {
        return orders;
    }

    @POST
    @Path("orders")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean addOrder(Order newOrder) {
        System.out.println(newOrder);
        orders.add(newOrder);
        System.out.println(orders);
        return true;
    }

    @GET
    @Path("order/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Order getSingleOrder(@PathParam("id") int id){
        return orders.get(id);
    }

    @GET
    @Path("order/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean updateOrder(Order o, @PathParam("id") int id){
        System.out.println("Updating order id: " + id);
        OrderDAO od = new OrderDAO();
        od.update(o);
        return true;
    }

    @DELETE
    @Path("delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean deleteOrder(Order newItem, @PathParam("id") int id){
        System.out.println("Deleting item id:" + id);
        OrderDAO dao = new OrderDAO();
        dao.delete(id);
        return true;
    }
}