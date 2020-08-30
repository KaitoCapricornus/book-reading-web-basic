<%-- 
    Document   : login
    Created on : Apr 30, 2019, 11:54:46 AM
    Author     : dinht
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
    <center>
        <h1>Login</h1>
        <form action="login" method="POST">
            <table>
                <tr>
                    <td>Username</td>
                    <td><input type="text" name="username" value="${requestScope.username}"/></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password" value="${requestScope.password}"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="checkbox" name="remember" value="true"/>Remember me</td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Login"/></td>
                </tr>
            </table>
        </form>
    </center>
</body>
</html>
