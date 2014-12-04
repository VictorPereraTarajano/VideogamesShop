<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="utilities.DecimalFormater"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Product"%>
<%@page import="model.ShoppingCart"%>
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
            <h3 class="modal-title" id="myModalLabel">MY CART</h3>
            <table class="table table-hover"><tr><th>GAME</th><th>PRIZE</th><th>REMOVE</th></tr>
                <%
                            
                    ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("Cart");
                    ArrayList<Product> cartList = cart.getCart();
                    double total = 0;
                            
                    for (int i = 0; i < cartList.size(); i++) {
                        Product product = cartList.get(i);
                        out.println("<tr class=\"info\"><td><h4>" + product.getName() + "</h4></td><td><h4>" + product.getPrize() + " €</h4></td><td>"
                            + "<form action=\"frontcontroller\" method=\"POST\">"
                                + "<input type=\"hidden\" name=\"command\" value=\"RemoveCMD\">"
                                + "<input type=\"hidden\" name=\"productID\" value=" + (i + 1) + ">"
                                + "<button type=\"submit\" class=\"btn btn-default alert-danger\"><span class=\"glyphicon glyphicon-remove\"></span></button>"
                            + "</form></td></tr>");
                        total += product.getPrize();
                    }
                    cart.setTotal(total);
                %>
                </table>
            <button id="remove" class="btn btn-default"><h4>TOTAL : <%=DecimalFormater.format(total) %> <span class="glyphicon glyphicon-euro"></span></h4></button>
        </div>
        <div class="modal-footer">
            <form action="frontcontroller" method="POST">
                <input type="hidden" name="command" value="InfoUserCMD">
                <%
                    if (!cartList.isEmpty()) out.println("<button type=\"submit\" id=\"buttonCart\" class=\"btn btn-primary btn-lg pull-right\">BUY <span class=\"glyphicon glyphicon-ok\"></span></button>");
                %>
            </form>
            <form action="frontcontroller" method="POST">
                <input  type="hidden" name="command" value="HomeCMD">
                <button type="submit" id="buttonCart" class="btn btn-default btn-lg alert-danger pull-right">HOME <span class="glyphicon glyphicon-home"></span></button>
            </form>
        </div>
    </body>
</html>

