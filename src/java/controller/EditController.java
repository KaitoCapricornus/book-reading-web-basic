/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.BookDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Book;
import model.BookChapters;

/**
 *
 * @author dinht
 */
public class EditController extends BaseRequiredAuthenticationController {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDAO db = new BookDAO();
        String bookID = request.getParameter("book");
        Book b = db.get(bookID);
        ArrayList<BookChapters> bc = db.getAllChapterOf(bookID);
        
        request.setAttribute("chapters", bc.size() == 0 ? null : bc);
        //request.setAttribute("totalchap", totalChapter);
        request.setAttribute("book", b);
        request.getRequestDispatcher("/view/edit.jsp").forward(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
