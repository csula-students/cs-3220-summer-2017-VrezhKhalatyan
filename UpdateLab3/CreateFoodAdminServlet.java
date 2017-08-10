package edu.csula;
import java.util.List;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/admin/foods/create")
public class CreateFoodAdminServlet extends HttpServlet {
	public void doGet( HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<form method=\"post\">");
		out.println("Food name: <input name='name' type='text'/></br>");
		out.println("<textarea name='description'></textarea></br>");
		out.println("<button>Add</button>");
		out.println("</form>");
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<FoodItem> entries = (List<FoodItem>) getServletContext().getAttribute("entries");
		entries.add(new FoodItem(entries.size(), request.getParameter("name"), request.getParameter("description")));
		getServletContext().setAttribute("entries", entries);
		PrintWriter out = response.getWriter();
		out.println("<a href='/admin/foods/'>go back to fooditem</a>");
	}
}