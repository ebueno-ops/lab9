<%-- 
    Document   : forgot
    Created on : 10-Apr-2022, 9:14:03 PM
    Author     : emman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Forgot Password</h1>
        <form action="forgot" method="post">
        Please enter your email address to retrieve your password.<br>
        Email Address: <input type="text" name="email"><br>
        <input type="submit" value="Submit">
        </form>
    </body>
</html>
