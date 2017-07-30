package edu.csula;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

import java.util.List;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/foodItems/create")
public class CreateFoodItemServlet extends HttpServlet {
    public void doGet( HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/foodItem-add.jsp")
            .forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String foodName = request.getParameter("foodName");
        String description = request.getParameter("description");
        Double price = Double.parseDouble(request.getParameter("price"));
        
        FoodItem newEntry = new FoodItem(-1, foodName, description, price);

        FoodItemDAO dao = new FoodItemDAO();
        dao.add(newEntry);
        response.sendRedirect("../foodItems");
	}
}