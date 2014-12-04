<%@page import="java.util.ArrayList"%>
<%@page import="model.Product"%>
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
        <title>Info Game View</title>
    </head>
    <body>

        <%
            ArrayList<Product> list = (ArrayList<Product>) request.getSession().getAttribute("Productos");
            Product product = (Product) list.get(Integer.parseInt(request.getParameter("productID")));

        %>

        <div class="modal-body">
            <h4 class="modal-title" id="myModalLabel"><%=product.getName()%></h4>
            <img src=" <%= product.getURLimage()%> " alt="..." >
            <h3> <%= product.getName()%></h3>
            <p>  <%= product.getDescription()%> </p>
            <p>
                <form action="frontcontroller" method="POST">
                    <input type="hidden" name="command" value="AddCMD">
                    <input type="hidden" name="productID" value="<%= product.getID()%>">
                    <button type="submit" id="buttonCart" class="btn btn-primary btn-lg pull-left">ADD <span class="glyphicon glyphicon-plus"></span></button>
                </form>
                <form action="frontcontroller" method="POST">
                    <input type="hidden" name="command" value="HomeCMD">
                    <button type="submit" id="buttonCart" class="btn btn-primary btn-lg pull-left">HOME <span class="glyphicon glyphicon-home"></span></button>
                <form>
            </p>
        </div>
    </body>
</html>
