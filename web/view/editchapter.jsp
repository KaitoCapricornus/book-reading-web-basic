<%-- 
    Document   : editchapter
    Created on : Apr 30, 2019, 7:09:14 PM
    Author     : dinht
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Chapter</title>
    </head>
    <body>
    <center>
        <form action="editchapter" method="POST">
            <h1>Edit ${requestScope.chapter.get(0)}</h1>
            Chapter name: <input type="text" name="chaptername" value="${requestScope.chapter.get(0)}"/>
            <textarea name="content" style="width: 100%; height: 100%; font-family: serif; font-size: 25px">${requestScope.chapter.get(1)}</textarea>
            <input type="hidden" name="book" value="${requestScope.bookid}"/>
            <input type="hidden" name="chapter" value="${requestScope.chapid}"/>
            <input type="submit" value="Done"/>
        </form>
    </center>
</body>
</html>
