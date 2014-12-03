<%@page import="discount.Discount"%>
<%@page import="interfaces.ICatalog"%>
<%@page import="interfaces.IShoppingCart"%>
<%@page import="interfaces.IShoppingCart"%>
<%@page import="interfaces.ICatalog"%>
<%@page import="interfaces.IShoppingCart"%>
<%@page import="utilities.DecimalFormater"%>
<%@page import="entities.Product"%>
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
        <h1 ><b>GAMES OF THE WEEK</b></h1>

        <%
            ICatalog catalog = (ICatalog) request.getSession().getAttribute("Catalog");
            IShoppingCart cart = (IShoppingCart) request.getSession().getAttribute("ShoppingCart");
        %>
        
        <form action="frontcontroller" method="POST">
            <input type="hidden" name="command" value="CartCMD">
            <button type="submit" id="buttonCart" class="btn btn-primary btn-lg"><span class="glyphicon glyphicon-shopping-cart"></span><b>VIEW CART</b></button>        
            <button type="button" id="buttonCart" class="btn btn-primary btn-success btn-lg"><b><%=cart.getTotalProducts()%> <span class="glyphicon glyphicon-tags"></b></span></button>
        </form>
        <form action="frontcontroller" method="POST">
            <input type="hidden" name="command" value="StatsCMD">
            <button type="submit" id="buttonCart" class="btn btn-primary btn-danger btn-lg"><b>STATS <span class="glyphicon glyphicon-cog"></b></span></button>
        </form>
        
        <div class="row">
        <%
            
           ArrayList<Product> list = catalog.getCatalog();
        
            for (int i = 0; i < list.size(); i++) {
                Product product = list.get(i);

                out.println("<div class=\"col-sm-6 col-md-4\">"
                        + "<div class=\"thumbnail\">"
                        + "<img src=\"" + product.getURLimage() + "\" alt=\"...\" style=\"height: 380px;width: 280px\">"
                        + "<div class=\"caption\">"
                        + "<h3><b>" + product.getName().toUpperCase() + "</b></h3>"
                        + "<form action=\"frontcontroller\" method=\"POST\">"
                        + "<input type=\"hidden\" name=\"command\" value=\"AddCMD\">"
                        + "<input type=\"hidden\" name=\"productID\" value=" + (product.getID()-1) + ">"
                        + "<button type=\"submit\" class=\"btn btn-primary btn-lg pull-left\"><b> ADD  </b><span class=\"glyphicon glyphicon-plus\"></span></button>"
                        + "</form>"
                        + "<form action=\"frontcontroller\" method=\"GET\">"
                        + "<input type=\"hidden\" name=\"productID\" value=\""+(product.getID()-1)+"\">"
                        + "<input type=\"hidden\" name=\"command\" value=\"InfoCMD\">"
                        
                        + "<button type=\"submit\" class=\"btn btn-primary btn-lg\" ><b>INFO </b><span class=\"glyphicon glyphicon-info-sign\"></span></button>"
                        + "<button class=\"btn btn-danger btn-lg pull-right disabled \" ><b>" + DecimalFormater.format((double) product.getPrice()) + " <span class=\"glyphicon glyphicon-euro\"></span></b></button>"
                        + "</form>"
                        + "<h4><b>DISCOUNT : ");
                        Discount disc = product.getDiscount();
                        
                        if (disc != null && product.getDiscount().isRated()) 
                            out.print(" "+disc.getName()+" a "+disc.getRated()+" %");
                        else
                            out.print(" "+disc.getName());
                        
                        out.print("</b></h4>"
                        + "</div>"
                        + "</div>"
                        + "</div>");
            }

        %>
        </div>
    </body>
</html>