<%-- 
    Document   : library
    Created on : Apr 30, 2019, 4:05:56 PM
    Author     : dinht
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Library</title>
    </head>
    <body>
    <center>
        <h1>${requestScope.user.getUsername()}のLibrary</h1>
        <table cellpadding="50">
            <c:forEach items="${requestScope.library}" var="b">
                <tr>
                    <td width="300px"><a href="listchapter?book=${b.getBookID()}">${b.getBookName()}</a></td>
                    <td width="80px">${b.getAuthor()}</td>
                    <td width="600px">${b.getReview()}</td>
                    <td width="200px">${b.getType()}</td>
                    <td>
                        <a href="delete?book=${b.getBookID()}"><button>Delete</button></a>
                        <a href="edit?book=${b.getBookID()}"><button ${requestScope.user.getUsername().equals(b.getAuthor()) ? "" : "disabled"}>Edit</button></a>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="5">
                    <center><a href="addnewbook"><button ${requestScope.user.getType().equals("Author") ? "" : "disabled"}>Add your own new book</button></a></center>
                </td>
            </tr>
        </table>
    </center>
</body>
</html>
