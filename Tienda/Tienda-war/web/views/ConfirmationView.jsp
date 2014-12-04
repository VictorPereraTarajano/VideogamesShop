<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.DateFormat"%>
<%@page import="utilities.DecimalFormater"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Product"%>
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
        <title>Confirmation View</title>
    </head>
    <body>       
        <h1>REVIEW OF THE BUY</h1>
        
        <div class="modal-body">
            <table class="table-hover">
                <%
                    ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("Cart");
                    
                    DateFormat dateFormat = new SimpleDateFormat("dd//MM/yyyy HH:mm:ss");
                    cart.setDate(Calendar.getInstance().getTime());
                %>
                <tr class="info"><td><h3>DATE    : </h3></td><td><h3><%= cart.getDate() %></h3></td></tr>
                <tr class="info"><td><h3>NAME    : </h3></td><td><h3><%= request.getParameter("name")%></h3></td></tr>
                <tr class="info"><td><h3>SURNAME : </h3></td><td><h3><%= request.getParameter("surname")%></h3></td></tr>
                <tr class="info"><td><h3>EMAIL   : </h3></td><td><h3><%= request.getParameter("email")%></h3></td></tr>
                <tr class="info"><td><h3>CARD    : </h3></td><td><h3><%= request.getParameter("cardnumber")%></h3></td></tr>
                <tr class="info"><td><h3>MMYY    : </h3></td><td><h3><%= request.getParameter("mmyy")%></h3></td></tr>
                <tr class="info"><td><h3>CVC     : </h3></td><td><h3><%= request.getParameter("cvc")%></h3></td></tr>
            </table>
        </div>
        
        <div class="modal-body">
            <h3 class="modal-title" id="myModalLabel">SHOPPING CART</h3>
            <br>
            <table class="table table-hover"><tr><th>GAME</th><th>PRIZE</th></tr>
                <%
                            
                    ArrayList<Product> cartList = cart.getCart();
                    double total = 0;
                            
                    for (int i = 0; i < cartList.size(); i++) {
                        Product product = cartList.get(i);
                        out.println("<tr class=\"info\"><td><h4>" + product.getName() + "</h4></td><td><h4>" + product.getPrize() + " €</h4></td><td>");
                        total += product.getPrize();
                    }
                    cart.setTotal(total);
                %>
                </table>
            <button id="remove"class="btn btn-default "><h4>TOTAL : <%=DecimalFormater.format(total) %> €</h4></button>

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
