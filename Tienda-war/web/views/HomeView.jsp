<%@page import="javax.naming.InitialContext"%>
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
            int catalogPage = 1;
            if (request.getParameter("Page") != null) catalogPage = Integer.parseInt(request.getParameter("Page"));
                       
            ICatalog catalog = (ICatalog) new InitialContext().lookup("java:app/Tienda-ejb/Catalog");
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
            for (Product product : catalog.getPage(catalogPage)) {
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
                        + "<button class=\"btn btn-danger btn-lg pull-right disabled \" ><b>" + DecimalFormater.format(product.getPrice())+ " €</b></button>"
                        + "</form>"
                        + "<button class=\"btn btn-warning btn-lg pull-right disabled \" ><b> DISC/IVA INC. </b></button>"
                        + "<h4><b>PRICE BEFORE: "+product.getPricePerUnit()+" €</b></h4>"
                        + "</div>"
                        + "</div>"
                        + "</div>");
            }

        %>
        </div>
        <div class="containerButton">
            <form action="frontcontroller" method="GET">
                <input type="hidden" name="command" value="HomeCMD">
                <input type="hidden" name="Page" value="<%=(catalogPage + 1)%>">
                <button type="submit" id="buttonNext" class="btn btn-danger btn-lg"><span class="glyphicon glyphicon-circle-arrow-right"></span><b> NEXT</b></button>        
            </form>
            <form action="frontcontroller" method="GET">
                <input type="hidden" name="command" value="HomeCMD">
                <input type="hidden" name="Page" value="<%=(catalogPage - 1)%>">
                <button type="submit" id="buttonLeft" class="btn btn-danger btn-lg"><span class="glyphicon glyphicon-circle-arrow-left"></span><b> PREVIOUS</b></button>        
            </form>
        </div>
    </body>
</html>