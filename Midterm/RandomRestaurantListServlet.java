import java.io.*;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(loadOnStartup=1, urlPatterns={"/suggest/restaurants/random/list"})
public class RandomRestaurantListServlet extends HttpServlet {
	public void init() {
		
		List<Restaurant> entries = new ArrayList<>();
		entries.add(new Restaurant(entries.size(), "Student # restuaruant", "http://cs3.calstatela.edu:8080/cs3220xstu1/suggest/restaurants/random"));
		getServletContext().setAttribute("entries", entries);
	}

	public void doGet( HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		List<Restaurant> entries = (List<Restaurant>) getServletContext().getAttribute("entries");
		// tell browser this is html document
		response.setContentType("text/html");

		out.println("<head>");
		out.println("<style>body { " +
		"}</style>");
		out.println("</head>");

		out.println("<h1>Whats for lunch! </h1>");
		out.println("<table>");
		for (Restaurant entry: entries) {
			out.println(
				"<tr>" + 
                    "<td>" + entry.getId() + "</td>" +
					"<td>" + entry.getName() + "</td>" + 
					"<td>" + entry.getURL() + "</td>" +
                    "<td>" + entry.getDesignRatings() + "</td>" +
                    "<td>" + entry.getTasteRatings() + "</td>" +
				"</tr>"
			);
		}
		out.println("</table>");
         out.println("<input type='button' name='list_button' value='See the List'>");
		out.println("<a href='/suggest/restaurants/random'>See the List</a>");
        out.println("<input type='button' name='lucky_button' value='Feeling Lucky'>");
        out.println("<a href= '../'>Feeling Lucky</a>");
		out.println("<a href='guestbook/create'>Add comemnt</a>");
	}
}