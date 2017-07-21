import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.*;

public class AdminHeader extends SimpleTagSupport {
   public void doTag() throws JspException, IOException {
      JspWriter out = getJspContext().getOut();
      out.println("<img src= 'logo.jpg' alt = 'logo' width = '100'>");
      out.println("<h1>THE VREZH RESTAURANT--ADMIN</h1>");
      out.println("<h2>Bringing <strong>Dynamic</strong> Gastronomy to the Table</h2>");
   }
}