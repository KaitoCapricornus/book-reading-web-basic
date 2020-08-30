/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.editchapter;

import controller.BaseRequiredAuthenticationController;
import dal.BookDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dinht
 */
public class EditChapterController extends BaseRequiredAuthenticationController {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String chapID = request.getParameter("chapter");
        String BookID = request.getParameter("book");
        BookDAO db = new BookDAO();
        ArrayList<String> chapter = db.getChapter(BookID, Integer.parseInt(chapID));
        request.setAttribute("chapter", chapter);
        request.setAttribute("chapid", chapID);
        request.setAttribute("bookid", BookID);
        request.getRequestDispatcher("/view/editchapter.jsp").forward(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String chapID = request.getParameter("chapter");
        String BookID = request.getParameter("book");
        String bookname = request.getParameter("chaptername");
        String content = request.getParameter("content");
        BookDAO db = new BookDAO();
        db.edit(BookID, chapID, bookname, content);
        response.sendRedirect("/BookReadingWeb/library");
    }

}
