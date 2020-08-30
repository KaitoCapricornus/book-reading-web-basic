<%-- 
    Document   : homepage
    Created on : Apr 28, 2019, 10:53:37 AM
    Author     : dinht
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix = "mt" uri = "../WEB-INF/tlds/Mytag_library.tld" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>カイト　の　Novel web - Home Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
    <center>
        <h1>カイト　の　Novel web</h1>

        <div class="floatTop">
            <a href="/BookReadingWeb/library">Your Library</a> &nbsp;&nbsp;&nbsp;&nbsp;
            <a href="/BookReadingWeb/search">Search</a>&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="/BookReadingWeb/login">Log in</a>&nbsp;&nbsp;&nbsp;&nbsp; 
            <a href="/BookReadingWeb/logout">Log out</a>&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="/BookReadingWeb/register">Register</a>&nbsp;&nbsp;&nbsp;&nbsp;
        </div>

        <table cellpadding="50">
            <tr>
                <th>Book name</th>
                <th>Author</th>
                <th>Review</th>
                <th>Types</th>
            </tr>
            <c:forEach items="${requestScope.books}" var="b">
                <tr style="text-align: center">
                    <td><a href="listchapter?book=${b.getBookID()}">${b.getBookName()}</a></td>
                    <td width="100px">${b.getAuthor()}</td>
                    <td width="1000px" style="text-align: left">${b.getReview()}</td>
                    <td width="200px">${b.getType()}</td>
                </tr>
            </c:forEach>
        </table>

        <mt:Paging gap="${requestScope.gap}"
                   pageindex="${requestScope.pageindex}"
                   totalpage="${requestScope.totalpage}"
                   website="home">
        </mt:Paging>
    </center>
</body>
</html>
