<%-- 
    Document   : listchapter
    Created on : Apr 29, 2019, 8:45:47 PM
    Author     : dinht
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${requestScope.book.getBookName()}</title>
    </head>
    <body>
    <center><h1>${requestScope.book.getBookName()}</h1></center>
    <center>
        <table cellpadding="50">
            <tr>
                <td width="100px">Author</td>
                <td width="800px">${requestScope.book.getAuthor()}</td>
            </tr>
            <tr>
                <td width="100px">Review</td>
                <td width="800px">${requestScope.book.getReview()}</td>
            </tr>
            <tr>
                <td width="100px">Type</td>
                <td width="800px">${requestScope.book.getType()}</td>
            </tr>
            <tr>
                <td colspan="2">
            <center><a href="addtolibrary?book=${requestScope.book.getBookID()}"><button>Add to library</button></a></center>
                </td>
            </tr>
        </table>
        <div><b style="font-size: 20px">Chapter List</b></div>
        <c:if test="${requestScope.chapters != null}">
            <table cellpadding="20">

                <c:forEach items="${requestScope.chapters}" var="c">
                    <tr>
                        <td><a href="story?book=${requestScope.book.getBookID()}&chap=${c.getChapID()}">${c.getChapterName()}</a></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        <c:if test="${requestScope.chapters == null}">
            Updating...
        </c:if>
    </center>

</body>
</html>
