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
        <title>Final View</title>
    </head>
    <body>
        <h1>Thanks for buy</h1>
        
        <p>Your codes has been sent to your email.</p>
        
        <form action="frontcontroller" method="POST">
            <input type="hidden" name="Page" value="1">
            <input type="hidden" name="command" value="HomeCMD">
            <button type="submit" id ="buttonCart" class="btn btn-primary btn-lg pull-right">HOME <span class="glyphicon glyphicon-home"></span></button>
        </form>
    </body>
</html>
