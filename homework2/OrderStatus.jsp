<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <title>Shopping Cart</title>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
    </head>

    <body>
        <%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
        <c: AdminHeader/>
        <p><font face="Verdana, Arial, Helvetica, sans-serif"><strong>Shopping Cart</strong></font></p>
        <p><a href="/Inventory!.jsp" mce_href="Inventory!.jsp">Model List</a> </p>
        <table width="75%" border="1">
            <tr bgcolor="#CCCCCC">
            <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Model
                Description</font></strong></td>
            <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Quantity</font></strong></td>
            <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Unit
                Price</font></strong></td>
            <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Total</font></strong></td>
            </tr>
            <jsp:useBean id="cart" scope="session" class="in.shoppingcart.beans.OrderStatus" />
            <c:if test="${cart.lineItemCount==0}">
            <tr>
                <td colspan="4"><font size="2" face="Verdana, Arial, Helvetica, sans-serif">- Cart is currently empty -<br/>
            </tr>
            </c:if>
            <c:forEach var="foodItm" items="${cart.foodItems}" varStatus="i">
            <form name="food" method="POST" action="servlet/OrderStatusServlet">
            <tr>
            <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><b><c:out value="${foodItm.partNumber}"/></b><br/>
                <c:out value="${foodItm.modelDescription}"/></font></td>
            <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><input type='hidden' name='itemIndice' value='<c:out value="${i.count}"/>'><input type='text' name="quantity" value='<c:out value="${foodItm.quantity}"/>' size='2'> <input type="submit" name="action" value="Update">
                <br/> <input type="submit" name="action" value="Delete"></font></td>
            <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif">$<c:out value="${foodItm.unitCost}"/></font></td>
            <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif">$<c:out value="${foodItm.totalCost}"/></font></td>
            </tr>
            </form>
                </c:forEach>
                <tr>
                    <td colspan="2"> </td>
                    <td> </td>
                    <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Subtotal: $<c:out value="${cart.orderTotal}"/></font></td>
                </tr>
<       /table>
    </body>
</html>