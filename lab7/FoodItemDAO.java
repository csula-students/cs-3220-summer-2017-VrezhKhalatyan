package edu.csula.jaxrs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import javax.ws.rs.PathParam;

public class FoodItemDAO{
    Connection c = null;
    private static final String DELETE = "DELETE FROM foodItems WHERE id=?";
    private static final String UPDATE = "UPDATE foodItems SET id=?, foodName=?, description=?, price=?";
    public List<FoodItem> list() {
        List<FoodItem> list = new ArrayList<>();
        Database db = new Database();
        try (Connection c = db.connection()) {
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM foodItems");
            while (rs.next()) {
                list.add(new FoodItem(
                    rs.getInt("id"),
                    rs.getString("foodName"),
                    rs.getString("description"),
                    rs.getDouble("price")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return list;
        }
        return list;
    }

    public Optional<FoodItem> get(int id) {
        return Optional.empty();
    }

    public void add(FoodItem entry) {
        Database db = new Database();
        try (Connection c = db.connection()) {
            PreparedStatement pstmt = c.prepareStatement("INSERT INTO foodItems (id, foodName, description, price) VALUES (?, ?, ?, ?)");
            pstmt.setInt(1, entry.getId());
            pstmt.setString(2, entry.getFoodName());
            pstmt.setString(3, entry.getDescription());
            pstmt.setDouble(4, entry.getPrice());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(FoodItem entry) {
         try {
            PreparedStatement ps = c.prepareStatement(UPDATE);
            ps.setInt(1, entry.getId());
            ps.setString(2, entry.getFoodName());
            ps.setString(3, entry.getDescription());
            ps.setDouble(4, entry.getPrice());
             
            ps.executeUpdate();
            ps.close();
 
            System.out.println("User with id " + entry.getId() + " was updated in DB ");
 
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {
         try {
            PreparedStatement ps = c.prepareStatement(DELETE);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
 
            System.out.println("User with id: " + id + " was sucesfully deleted from DB.");
 
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}