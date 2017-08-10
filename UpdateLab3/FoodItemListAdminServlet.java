package edu.csula;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(loadOnStartup=1, urlPatterns={"/admin/foods/"})
public class FoodItemListAdminServlet extends HttpServlet {
	public void init() {
		// init the application scope to have pre-set values
		List<FoodItem> entries = new ArrayList<>();
		entries.add(new FoodItem(entries.size(), "Ramen", "Japanese Soup"));
		entries.add(new FoodItem(entries.size(), "Menudo", "Mexican Soup"));
        entries.add(new FoodItem(entries.size(), "Khash", "Armenian Soup"));
		getServletContext().setAttribute("entries", entries);
	}

	public void doGet( HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		List<FoodItem> entries = (List<FoodItem>) getServletContext().getAttribute("entries");
		// tell browser this is html document
		response.setContentType("text/html");

		out.println("<head>");
		out.println("<style>body { " +
		"}</style>");
		out.println("</head>");

		out.println("<h1> Vrezh Restaurant! </h1>");
		out.println("<table>");
		for (FoodItem entry: entries) {
			out.println(
				"<tr>" + 
					"<td>" + entry.getName() + " </td>" + 
					"<td>" + entry.getDescription() + " </td>" + 
					"<td><a href='edit?id=" + entry.getId() + "'>Edit</a> " + 
					"<a href='delete?id=" + entry.getId() + "'>Delete</a></td>" +
				"</tr>"
			);
		}
		out.println("</table>");
		out.println("<a href='create'>Add description</a>");
	}
}