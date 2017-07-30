package edu.csula;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.List;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/foodItems")
public class FoodItemServlet extends HttpServlet {

    public void doGet( HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        FoodItemDAO dao = new FoodItemDAO();
        request.setAttribute("list", dao.list());

        request.getRequestDispatcher("/WEB-INF/foodItem.jsp")
            .forward(request, response);
    }
}