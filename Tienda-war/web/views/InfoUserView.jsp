<%@page import="interfaces.IShoppingCart"%>
<%@page import="entities.Client"%>
<%@page import="java.util.List"%>
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
        <title>Info User View</title>
    </head>
    <body>
        <div class="modal-body" id="Buy1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <form action="frontcontroller" method="GET">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                            <h4 class="modal-title" id="myModalLabel">AUTHENTICATION FORM</h4>
                        </div>
                        
                        <%                           
                            IShoppingCart cart = (IShoppingCart) request.getSession().getAttribute("ShoppingCart");
                            Client client = cart.getClient();
                            
                            if (client == null) {
                                client = new Client("","","","","","");
                                request.getSession().setAttribute("Client", client);
                            }
                            
                        %>
                        <div class="modal-body">
                            <div class="input-group">
                                <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                                <input id="name" name="name" type="text" class="form-control" placeholder="Name" value="<%=client.getName()%>">
                                <input name="surname" type="text" class="form-control" placeholder="Surname" value="<%=client.getSurname()%>">
                            </div>
                            <div class="input-group">
                                <span class="input-group-addon"><span class="glyphicon glyphicon-globe"></span></span>
                                <input name="email" type="text" class="form-control" placeholder="Email" value="<%=client.getEmail()%>">
                            </div>
                            <div class="input-group">
                                <span class="input-group-addon"><span class="glyphicon glyphicon-credit-card"></span></span>
                                <input name="cardnumber" type="text" class="form-control" placeholder="Card Number" value="<%=client.getCardnumber()%>">
                            </div>
                            <div class="input-group">
                                <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                                <input name="mmyy" type="text" class="form-control" placeholder="MM/YY" value="<%=client.getMmyy()%>">
                            </div>
                            <div class="input-group">
                                <span class="input-group-addon"><span class="glyphicon glyphicon-link"></span></span>
                                <input name="cvc" type="text" class="form-control" placeholder="CVC" value="<%=client.getCvc()%>">
                            </div> 
                        </div>
                        <div class="modal-footer">
                            <input type="hidden" name="command" value="ConfirmationCMD">
                            <button type="submit" class="btn btn-primary btn-lg">REVIEW AND FINISH <span class="glyphicon glyphicon-ok"></span></button>
                        </div>
                        </form>
                        <form action="frontcontroller" method="POST">
                            <input type="hidden" name="command" value="HomeCMD">
                            <button type="submit" id="buttonCart" class="btn btn-primary btn-lg pull-right">HOME <span class="glyphicon glyphicon-home"></span></button>
                        </form>
                        <form action="frontcontroller" method="POST">
                            <input type="hidden" name="command" value="CartCMD">
                            <button type="submit" id="buttonCart" class="btn btn-primary btn-lg pull-right">CART <span class="glyphicon glyphicon glyphicon-shopping-cart"></span></button>
                        </form>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
