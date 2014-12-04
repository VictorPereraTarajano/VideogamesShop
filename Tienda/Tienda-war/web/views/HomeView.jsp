<%@page import="utilities.DecimalFormater"%>
<%@page import="model.Product"%>
<%@page import="model.ShoppingCart"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="en">
    <head>
        <title>Home View</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/bootstrap.min.css" rel="stylesheet"> 
        <link href="css/mystyle.css" rel="stylesheet">      
    </head>
    <body>
        <h1 >GAMES OF THE WEEK</h1>

        <%
            ArrayList<Product> list = (ArrayList<Product>) request.getSession().getAttribute("Productos");
            ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("Cart");
        %>
        
        <form action="frontcontroller" method="POST">
            <input type="hidden" name="command" value="CartCMD">
            <button type="submit" id="buttonCart" class="btn btn-primary btn-lg"><span class="glyphicon glyphicon-shopping-cart"></span> VIEW CART</button>        
            <button type="button" id="buttonCart" class="btn btn-primary btn-success btn-lg"><b><%=cart.getCart().size()%> <span class="glyphicon glyphicon-tags"></b></span></button>
        </form>
        
        <div class="row">
        <%

            for (int i = 0; i < list.size(); i++) {
                Product product = list.get(i);

                out.println("<div class=\"col-sm-6 col-md-4\">"
                        + "<div class=\"thumbnail\">"
                        + "<img src=\"" + product.getURLimage() + "\" alt=\"...\" style=\"height: 380px;width: 280px\">"
                        + "<div class=\"caption\">"
                        + "<h3>" + product.getName().toUpperCase() + "</h3>"
                        + "<form action=\"frontcontroller\" method=\"POST\">"
                        + "<input type=\"hidden\" name=\"command\" value=\"AddCMD\">"
                        + "<input type=\"hidden\" name=\"productID\" value=" + product.getID() + ">"
                        + "<button type=\"submit\" class=\"btn btn-primary btn-lg pull-left\"> ADD   <span class=\"glyphicon glyphicon-plus\"></span></button>"
                        + "</form>"
                        + "<form action=\"frontcontroller\" method=\"POST\">"
                        + "<input type=\"hidden\" name=\"productID\" value=\""+(product.getID()-1)+"\">"
                        + "<input type=\"hidden\" name=\"command\" value=\"InfoCMD\">"
                        
                        + "<button type=\"submit\" class=\"btn btn-primary btn-lg\" >INFO <span class=\"glyphicon glyphicon-info-sign\"></span></button>"
                        + "<button class=\"btn btn-danger btn-lg pull-right disabled \" ><b>" + DecimalFormater.format((double) product.getPrize()) + " <span class=\"glyphicon glyphicon-euro\"></span></b></button>"
                        + "</form>"
                        + "</div>"
                        + "</div>"
                        + "</div>");
            }

        %>
        </div>
    </body>
</html>