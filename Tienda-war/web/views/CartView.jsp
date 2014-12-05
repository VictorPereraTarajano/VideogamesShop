<%@page import="entities.ShoppingCart"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="interfaces.IShoppingCart"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="discount.Discount"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="utilities.DecimalFormater"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/bootstrap.min.css" rel="stylesheet"> 
        <link href="css/mystyle.css" rel="stylesheet">
        <title>Cart View</title>
    </head>
    <body>
        <div class="modal-body">
            <h3 class="modal-title" id="myModalLabel"><b>MY CART</b></h3>
            <table class="table table-hover"><tr><th><h4><b>GAME</b></h4></th><th><h4><b>PRICE PER UNIT</h4></b></th><th><h4><b>PRICE PER UNIT + DISCOUNT</h4></b></th><th><h4><b>AMOUNT</h4></b></th><th><h4><b>REMOVE</h4></b></th></tr>
                <%
                            
                    IShoppingCart cart = (IShoppingCart) request.getSession().getAttribute("ShoppingCart");
                            
                    for (Entry<Product, Integer> entry : cart.getCart().entrySet()) {
                        Product product = entry.getKey();           
                        Integer amount = entry.getValue();
                        out.println("<tr class=\"info\"><td><h4><a href=\"/Tienda-war/frontcontroller?productID="+(product.getID()-1)+"&command=InfoCMD\">" + product.getName() + "</a></h4></td><td><h4>" +product.getPricePerUnit() + " €</h4></td><td><h4>" +product.getDiscount(product, amount, false)+" €</h4></td><td><h4>" + amount + "</h4></td><td>"
                            + "<form action=\"frontcontroller\" method=\"POST\">"
                                + "<input type=\"hidden\" name=\"command\" value=\"RemoveCMD\">"
                                + "<input type=\"hidden\" name=\"productID\" value=" + (product.getID() - 1)+ ">"
                                + "<button type=\"submit\" class=\"btn btn-default alert-danger\"><span class=\"glyphicon glyphicon-remove\"></span></button>"
                            + "</form></td></tr>");
                    }
                    
                %>
                </table>
            <button id="remove" class="btn btn-default"><h4><b>SUBTOTAL : <%=DecimalFormater.format(cart.getSubTotal()) %> </b><span class="glyphicon glyphicon-euro"></span></h4></button>
            <button id="remove" class="btn btn-default"><h4><b>TOTAL [SUBTOTAL + DISCOUNTS + IVA] : <%=DecimalFormater.format(cart.getTotal()) %> </b><span class="glyphicon glyphicon-euro"></span></h4></button>
        </div>
        <div class="modal-footer">
            <form action="frontcontroller" method="POST">
                <input type="hidden" name="command" value="InfoUserCMD">
                <%
                    if (!cart.isEmpty()) out.println("<button type=\"submit\" id=\"buttonCart\" class=\"btn btn-primary btn-lg pull-right\">BUY <span class=\"glyphicon glyphicon-ok\"></span></button>");
                %>
            </form>
            <form action="frontcontroller" method="POST">
                <input type="hidden" name="Page" value="1">
                <input  type="hidden" name="command" value="HomeCMD">
                <button type="submit" id="buttonCart" class="btn btn-default btn-lg alert-danger pull-right">HOME <span class="glyphicon glyphicon-home"></span></button>
            </form>
        </div>
    </body>
</html>

