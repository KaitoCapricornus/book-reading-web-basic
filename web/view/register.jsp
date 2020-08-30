<%-- 
    Document   : register
    Created on : Apr 30, 2019, 1:26:58 PM
    Author     : dinht
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
    <center>
        <h1>Register</h1>
        <form action="register" method="POST">
            <table>
                <tr>
                    <td>Username</td>
                    <td><input type="text" name="username"/></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password"/></td>
                </tr>
                <tr>
                    <td>Confirm Password</td>
                    <td><input type="password" name="cfpassword"/></td>
                </tr>
                <tr>
                    <td>Type</td>
                    <td>
                        <input type="radio" name="type" value="Author"/>Author (Can create your own story)<br/>
                        <input type="radio" name="type" value="Guest" checked/>Guest (Default type - Just reading your favorite story)
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Register"/></td>
                </tr>
            </table>
        </form>
    </center>
    </body>
</html>
