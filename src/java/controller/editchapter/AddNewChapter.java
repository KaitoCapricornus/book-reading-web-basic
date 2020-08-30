/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.editchapter;

import controller.BaseRequiredAuthenticationController;
import dal.BookDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dinht
 */
public class AddNewChapter extends BaseRequiredAuthenticationController {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookid = request.getParameter("book");
        BookDAO db = new BookDAO();
        int chapterID = db.countChapter(bookid) + 1;
        request.setAttribute("bookid", bookid);
        request.setAttribute("chapid", chapterID);
        request.getRequestDispatcher("/view/addnewchapter.jsp").forward(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDAO db = new BookDAO();
        String bookid = request.getParameter("book");
        String chapid = request.getParameter("chapter");
        String chaptername = request.getParameter("chaptername");
        String content = request.getParameter("content");
        
        db.addChapter(bookid, chapid, chaptername, content);
        response.sendRedirect("/BookReadingWeb/edit?book=" + bookid);
    }

    

}
