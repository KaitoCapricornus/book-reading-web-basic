/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.BookDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dinht
 */
public class DeleteController extends BaseRequiredAuthenticationController {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String BookID = request.getParameter("book");
        request.setAttribute("data", BookID);
        request.getRequestDispatcher("/view/delete.jsp").forward(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cfDelete = request.getParameter("cfDelete");
        String BookID = request.getParameter("bookid");
        if (cfDelete.equals("Yes")) {
            BookDAO db = new BookDAO();
            db.delete(BookID);
        }
        response.sendRedirect("/BookReadingWeb/library");
    }

}
