<%-- 
    Document   : delete
    Created on : Apr 30, 2019, 4:45:24 PM
    Author     : dinht
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete</title>
    </head>
    <body>
        <h1>Do you really want to remove this book from your library???</h1>
        <form action="delete" method="POST">
            <input type="hidden" name="bookid" value="${requestScope.data}"/>
            <input type="submit" value="Yes" name="cfDelete"/>
            <input type="submit" value="No" name="cfDelete"/>
        </form>
    </body>
</html>
