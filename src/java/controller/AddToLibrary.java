/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.LibraryDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;
import model.User_Library;

/**
 *
 * @author dinht
 */
public class AddToLibrary extends BaseRequiredAuthenticationController {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookID = request.getParameter("book");
        String username = ((Account) request.getSession().getAttribute("user")).getUsername();
        LibraryDAO db = new LibraryDAO();
        if(db.isInUserLibrary(username, bookID)){
            response.sendRedirect("/BookReadingWeb/listchapter?book=" + bookID);
        }else{
            User_Library ul = new User_Library();
            ul.setUsername(username);
            ul.setBookID(bookID);
            db.insert(ul);
            response.sendRedirect("/BookReadingWeb/library");
        }
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
