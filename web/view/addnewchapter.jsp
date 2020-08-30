<%-- 
    Document   : addnewchapter
    Created on : Apr 30, 2019, 8:22:55 PM
    Author     : dinht
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Chapter</title>
    </head>
    <body>
    <center>
        <h1>Add new chapter</h1>
        <form action="addnewchapter" method="POST">
            Chapter name: <input type="text" name="chaptername"/><br/>
            Content:
            <textarea name="content" style="width: 100%; height: 100%; font-family: serif; font-size: 25px"></textarea>
            <input type="hidden" name="book" value="${requestScope.bookid}"/>
            <input type="hidden" name="chapter" value="${requestScope.chapid}"/>
            <input type="submit" value="Done"/>
        </form>
    </center>
</body>
</html>
