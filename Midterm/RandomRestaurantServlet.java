import java.util.List;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/suggest/restaurants/random")
public class RandomRestaurantServlet extends HttpServlet {
	public void doGet( HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
        out.println("<h1>What's for Lunch</h1><br>");
        out.println("<h2>You should go to:</h2><br>");
        out.println("<img src='restaurant-placeholder.png' alt='Restaurant Image' style='width:100px;height:100px;'><br>");
		out.println("Design:<br>");
        out.println("<input type='radio' name='design' id='design1' value='1'>");
        out.println("<label for='design1'>1</label><br>");
        out.println("<input type='radio' name='design' id='design2' value='2'>");
        out.println("<label for='design2'>1</label><br>");
        out.println("<input type='radio' name='design' id='design3' value='3'>");
        out.println("<label for='design3'>1</label><br>");
        out.println("<input type='radio' name='design' id='design4' value='4'>");
        out.println("<label for='design4'>1</label><br>");
        out.println("<input type='radio' name='design' id='design5' value='5'>");
        out.println("<label for='design5'>1</label><br><br>");

		out.println("Food Taste:<br>");
        out.println("<input type='radio' name='taste' id='taste1' value='1'>");
        out.println("<label for='taste1'>1</label><br>");
        out.println("<input type='radio' name='taste' id='taste2' value='2'>");
        out.println("<label for='taste2'>1</label><br>");
        out.println("<input type='radio' name='taste' id='taste3' value='3'>");
        out.println("<label for='taste3'>1</label><br>");
        out.println("<input type='radio' name='taste' id='taste4' value='4'>");
        out.println("<label for='taste4'>1</label><br>");
        out.println("<input type='radio' name='taste' id='taste5' value='5'>");
        out.println("<label for='taste5'>1</label><br><br>");

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Restaurant> entries = (List<Restaurant>) getServletContext().getAttribute("entries");
		entries.add(new Restaurant(entries.size(), request.getParameter("id"), request.getParameter("name"), request.getParameter("url"), 
                request.getParameter("designRatings"), request.getParameter("tasteRatings")));
		getServletContext().setAttribute("entries", entries);
		PrintWriter out = response.getWriter();
        out.println("<input type='button' name='list_button' value='See the List'>");
		out.println("<a href='/list'>See the List</a>");
        out.println("<input type='button' name='lucky_button' value='Feeling Lucky'>");
        out.println("<a href= '../'>Feeling Lucky</a>");
	}
}