<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.HashMap"%>
<%@page import="entities.Client"%>
<%@page import="interfaces.IShoppingCart"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.DateFormat"%>
<%@page import="utilities.DecimalFormater"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Product"%>
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
        <title>Confirmation View</title>
    </head>
    <body>       
        <h1>REVIEW OF THE BUY</h1>
        
        <div class="modal-body">
            <table class="table-hover">
                <%
                    IShoppingCart cart = (IShoppingCart) request.getSession().getAttribute("ShoppingCart");
                    
                    DateFormat dateFormat = new SimpleDateFormat("dd//MM/yyyy HH:mm:ss");
                    cart.setDate(Calendar.getInstance().getTime());
                    
                    Client client = cart.getClient();
                %>
                <tr class="info"><td><h3>DATE    : </h3></td><td><h3><%=cart.getDate() %></h3></td></tr>
                <tr class="info"><td><h3>NAME    : </h3></td><td><h3><%=client.getName()%></h3></td></tr>
                <tr class="info"><td><h3>SURNAME : </h3></td><td><h3><%=client.getSurname()%></h3></td></tr>
                <tr class="info"><td><h3>EMAIL   : </h3></td><td><h3><%=client.getEmail()%></h3></td></tr>
                <tr class="info"><td><h3>CARD    : </h3></td><td><h3><%=client.getCardnumber()%></h3></td></tr>
                <tr class="info"><td><h3>MMYY    : </h3></td><td><h3><%=client.getMmyy()%></h3></td></tr>
                <tr class="info"><td><h3>CVC     : </h3></td><td><h3><%=client.getCvc()%></h3></td></tr> 
            </table>
        </div>
        
        <div class="modal-body">
            <h3 class="modal-title" id="myModalLabel"><b>SHOPPING CART</b></h3>
                <table class="table table-hover"><tr><th><h4><b>GAME</b></h4></th><th><h4><b>PRICE PER UNIT</h4></b></th><th><h4><b>PRICE PER UNIT + DISCOUNT</h4></b></th><th><h4><b>AMOUNT</h4></b></th></tr>
                <%        
                    for (Entry<Product, Integer> entry : cart.getCart().entrySet()) {
                        Product product = entry.getKey();
                        Integer amount = entry.getValue();
                        out.println("<tr class=\"info\"><td><h4><a href=\"/Tienda-war/frontcontroller?productID="+(product.getID()-1)+"&command=InfoCMD\">" + product.getName() + "</a></h4></td><td><h4>" +product.getPricePerUnit() + " €</h4></td><td><h4>" +product.getDiscount(product, amount, false)+" €</h4></td><td><h4>" + amount + "</h4></td></tr>");
                    }        
                %>
                </table>
                <button id="remove" class="btn btn-default"><h4><b>SUBTOTAL : <%=DecimalFormater.format(cart.getSubTotal()) %> </b><span class="glyphicon glyphicon-euro"></span></h4></button>
                <button id="remove" class="btn btn-default"><h4><b>TOTAL [SUBTOTAL + DISCOUNTS + IVA] : <%=DecimalFormater.format(cart.getTotal()) %> </b><span class="glyphicon glyphicon-euro"></span></h4></button>
        </div>      
            <form action="frontcontroller" method="POST">
                <input type="hidden" name="command" value="InfoUserCMD">
                <button type="submit" id="buttonCart" class="btn btn-primary btn-lg pull-right">AUTHENTICATION FORM <span class="glyphicon glyphicon-align-justify"></span></button>
            </form>
            <form action="frontcontroller" method="POST">
                <input type="hidden" name="command" value="FinalCMD">
                <button type="submit" id="buttonCart" class="btn btn-primary btn-lg pull-right">CONFIRM <span class="glyphicon glyphicon-ok"></span></button>
            </form>
    </body>
</html>