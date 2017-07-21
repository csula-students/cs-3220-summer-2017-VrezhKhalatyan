import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OrderStatusServlet extends HttpServlet {
  
public void doPost(HttpServletRequest req, HttpServletResponse res)
throws ServletException, IOException {

    String act = req.getParameter("action");


    if(act!=null && !act.equals("")) {
        if(act.equals("add")) {
            addStatus(req);
        } else if (act.equals("Update")) {
            alteringStatus(req);
        } else if (act.equals("Delete")) {
            deleteStatus(req);
        }
    }
    res.sendRedirect("../Inventory.jsp");
    }
  
    protected void deleteStatus(HttpServletRequest req) {
        HttpSession session = req.getSession();
        String indexes = req.getParameter("foodIndex");
        OrderStatus os = null;

        Object foodCrt = session.getAttribute("cart");
        if(foodCrt!=null) {
            os = (OrderStatus) foodCrt ;
        } else {
            os = new OrderStatus();
        }
        os.deleteFoodItem(indexes);
    }   
  
    protected void alteringStatus(HttpServletRequest req) {
        HttpSession session = req.getSession();
        String quantities = req.getParameter("quantity");
        String indexes = req.getParameter("foodIndex");
  
        OrderStatus os = null;

        Object foodCrt = session.getAttribute("cart");
        if(foodCrt!=null) {
            os = (OrderStatus) foodCrt ;
        } else {
            os = new OrderStatus();
        }
        os.alterOrderStatus(indexes, quantities);
    }
  
    protected void addStatus(HttpServletRequest req) {
        HttpSession session = req.getSession();
        String id = req.getParameter("id");
        String description = req.getParameter("description");
        String price = req.getParameter("price");
        String quantities = req.getParameter("quantity");

        OrderStatus os = null;

        Object foodObject = session.getAttribute("cart");

        if(foodObject!=null) {
            os = (OrderStatus) foodObject ;
        } else {
            os = new OrderStatus();
            session.setAttribute("cart", os);
        }

        os.addingFood(id, description, price, quantities);
    }

}