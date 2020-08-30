<%-- 
    Document   : edit
    Created on : Apr 30, 2019, 6:39:50 PM
    Author     : dinht
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit</title>
    </head>
    <body>
    <center>
        <h1>Edit</h1>
        <table cellpadding="30">
            <tr>
                <td>Book Name</td>
                <td>${requestScope.book.getBookName()}</td>
            </tr>
            <c:forEach items="${requestScope.chapters}" var="c">
                <tr>
                    <td colspan="2">
                        <a href="editchapter?chapter=${c.getChapID()}&book=${requestScope.book.getBookID()}">
                            <center>${c.getChapterName()}</center></a>
                    </td>
                </tr>
            </c:forEach>
                <tr>
                    <td colspan="2"><center><a href="/BookReadingWeb/addnewchapter?book=${requestScope.book.getBookID()}"><button>Add new chapter</button></a></center></td>
                </tr>
        </table>
    </center>
</body>
</html>
