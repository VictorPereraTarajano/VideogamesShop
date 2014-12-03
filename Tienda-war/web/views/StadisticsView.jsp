<%@page import="javax.naming.InitialContext"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Product"%>
<%@page import="interfaces.IStadistics"%>
<%@page import="interfaces.IStadistics"%>
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
        <title>Stadistics View</title>
    </head>
    <body>       
        <div class="modal-body">
            <h3 class="modal-title" id="myModalLabel"><b>STADISTICS</b></h3>
                <table class="table table-hover">
                    <%
                        IStadistics stats = (IStadistics) new InitialContext().lookup("java:app/Tienda-ejb/Stadistics");
                    %>
                    <tr class="info"><td><h3><b>NUMBER OF HOME ACCESS : </b></h3></td><td><h3><%=stats.getNumAccess() %></h3></td></tr>
                    <tr class="info"><td><h3><b>NUMBER OF SHOPPING CART ACCESS : </b></h3></td><td><h3><%=stats.getNumAccessShoppingCart()%></h3></td></tr>
                    <tr class="info"><td><h3><b>NUMBER OF SUCCESSFUL BUYS : </b></h3></td><td><h3><%=stats.getNumSuccesfulBuys()%></h3></td></tr> 
                    <tr class="info"><td><h3><b>TOTAL : </h3></td><td><h3><%=stats.getTotal()%> € </b></h3></td></tr> 
                    <tr class="info"><td><h3><b>MOST PURCHASED PRODUCTS :</b></h3></td><td><h3>
                    <%
                        for (Product product : stats.getMostPurchasedProducts(5)) {
                            out.println(product.getName()+",");
                        }
                    %></h3></td></tr> 
                </table>
        </div>
        <form action="frontcontroller" method="POST">
            <input  type="hidden" name="command" value="HomeCMD">
            <button type="submit" id="buttonCart" class="btn btn-default btn-lg alert-danger pull-right">HOME <span class="glyphicon glyphicon-home"></span></button>
        </form>
    </body>
</html>
