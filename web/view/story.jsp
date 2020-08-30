<%-- 
    Document   : story
    Created on : Apr 29, 2019, 4:48:30 PM
    Author     : dinht
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${requestScope.chapter.get(0)}</title>
        <style>
            .divStyle{
                font-size: 25px;
                margin-right:200px;
                margin-left: 200px;
            }
        </style>
    </head>
    <body>
    <center><h1>${requestScope.chapterInfo.get(0)}</h1></center>

    <div class="divStyle">
        ${requestScope.chapterInfo.get(1)}
    </div>
    <center>
        <c:if test="${Integer.parseInt(requestScope.Chapter) == 1}">
            <a href="#"><button disabled>Previous</button></a> &nbsp;&nbsp;&nbsp; 
        </c:if>
        <c:if test="${Integer.parseInt(requestScope.Chapter) != 1}">
            <a href="story?book=${requestScope.BookID}&chap=${Integer.parseInt(requestScope.Chapter) - 1}"><button>Previous</button></a> 
            &nbsp;&nbsp;&nbsp; 
        </c:if>
        <c:if test="${Integer.parseInt(requestScope.Chapter) == Integer.parseInt(requestScope.totalChapter)}">
            <a href="#"><button disabled>Next</button></a>
        </c:if>
        <c:if test="${Integer.parseInt(requestScope.Chapter) != Integer.parseInt(requestScope.totalChapter)}">
            <a href="story?book=${requestScope.BookID}&chap=${Integer.parseInt(requestScope.Chapter) + 1}"><button>Next</button></a>
        </c:if>
    </center>
</body>
</html>
