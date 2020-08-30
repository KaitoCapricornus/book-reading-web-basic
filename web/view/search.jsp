<%-- 
    Document   : search
    Created on : Apr 30, 2019, 2:01:11 PM
    Author     : dinht
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "mt" uri = "../WEB-INF/tlds/Mytag_library.tld" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Book</title>
    </head>
    <body>
    <center>
        <h1>Search</h1>
        <form>
            <table cellpadding="30">
                <tr>
                    <td>Book name</td>
                    <td><input type="text" name="bookname" size="50"/></td>
                </tr>
                <tr>
                    <td>Type</td>
                    <td>
                        <input type="checkbox" name="types" value="Action"/>Action
                        <input type="checkbox" name="types" value="Isekai"/>Isekai
                        <input type="checkbox" name="types" value="Romance"/>Romance
                        <input type="checkbox" name="types" value="Novel"/>Novel
                        <input type="checkbox" name="types" value="Comedy"/>Comedy
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Search"/></td>
                </tr>
            </table>
        </form>
        <h2>
            <c:if test="${!(empty requestScope.bookname && empty requestScope.types)}">
                All Results for<br/>
                Book name: ${empty requestScope.bookname ? "Any" : requestScope.bookname} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                Type:
                <c:if test="${empty requestScope.types}">
                    Any
                </c:if>
                
            </c:if>
            <c:if test="${requestScope.types != null}">
                <c:forEach items="${requestScope.types}" var="t">
                    ${t}
                    <c:if test="${t != requestScope.types.get(requestScope.types.size() - 1)}">
                        &nbsp;-&nbsp;
                    </c:if>
                </c:forEach>
            </c:if>
        </h2>
        <table cellpadding="10">
            <c:forEach items="${requestScope.books}" var="b">
                <tr>
                    <td><a href="listchapter?book=${b.getBookID()}">${b.getBookName()}</a></td>
                    <td>${b.getAuthor()}</td>
                    <td>${b.getType()}</td>
                </tr>
            </c:forEach>
        </table>
    </center>
</body>
</html>
