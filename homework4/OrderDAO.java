package edu.csula;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

public class OrderDAO implements DAO<Order> {
    Connection c = null;
    private static final String DELETE = "DELETE FROM Orders WHERE id=?";
    private static final String UPDATE = "UPDATE Orders SET customerName=?, created=?";
    public List<Order> list() {
        List<Order> list = new ArrayList<>();
        Database db = new Database();
        try (Connection c = db.connection()) {
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Orders");
            while (rs.next()) {
                list.add(new Order(
                    rs.getInt("id"),
                    rs.getString("customerName"),
                    rs.getString("created")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return list;
        }
        return list;
    }

    public Optional<Order> get(int id) {
        return Optional.empty();
    }

    public void add(Order entry) {
        Database db = new Database();
        try (Connection c = db.connection()) {
            PreparedStatement pstmt = c.prepareStatement("INSERT INTO Orders (id, customerName, date) VALUES (?, ?, ?)");
            pstmt.setInt(1, entry.getId());
            pstmt.setString(1, entry.getName());
            pstmt.setString(2, entry.getDate());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Order entry) {
         try {
            PreparedStatement ps = c.prepareStatement(UPDATE);
            ps.setInt(1, entry.getId());
            ps.setString(2, entry.getName());
            ps.setString(3, entry.getDate());
             
            ps.executeUpdate();
            ps.close();
 
            System.out.println("User with id " + entry.getId() + " was updated in DB with following details: " + entry.toString());
 
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