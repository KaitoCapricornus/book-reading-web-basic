<%-- 
    Document   : addnewbook
    Created on : Apr 30, 2019, 9:03:00 PM
    Author     : dinht
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add new book</title>
    </head>
    <body>
    <center>
        <h1>Add new book</h1>
        <form action="addnewbook" method="POST">
            <input type="hidden" name="book" value="${requestScope.bookid}"/>
            <input type="hidden" name="author" value="${requestScope.user.getUsername()}"/>
            <table>
                <tr>
                    <td>Book Name</td>
                    <td><input type="text" name="bookname"/></td>
                </tr>
                <tr>
                    <td>Review</td>
                    <td> <textarea name="review" rows="15" cols="100"></textarea><br/></td>
                </tr>
                <tr>
                    <td>Type: </td>
                    <td>
                        <input type="checkbox" name="types" value="Action"/>Action&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="checkbox" name="types" value="Isekai"/>Isekai&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="checkbox" name="types" value="Romance"/>Romance&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="checkbox" name="types" value="Novel"/>Novel&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="checkbox" name="types" value="Comedy"/>Comedy&nbsp;&nbsp;&nbsp;&nbsp;
                    </td>
                </tr>
                <tr>
                    <td colspan="2"><center><input type="submit" value="Done"/></center></td>
                </tr>
            </table>
        </form>
    </center>
</body>
</html>
