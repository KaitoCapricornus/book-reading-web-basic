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
import model.Account;
import model.Book;

/**
 *
 * @author dinht
 */
public class AddNewBook extends BaseRequiredAuthenticationController {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Account a = (Account) request.getSession().getAttribute("user");
        if (a.getType().equals("Author")) {
            request.setAttribute("user", a);
            BookDAO db = new BookDAO();
            int bookid = (int) (db.countAllBook() + Math.random() % 10000);
            request.setAttribute("bookid", bookid);
            request.getRequestDispatcher("/view/addnewbook.jsp").forward(request, response);
        } else {
            response.sendRedirect("/BookReadingWeb/library");
        }
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDAO db = new BookDAO();
        String BookID = request.getParameter("book");
        String Author = request.getParameter("author");
        String bookname = request.getParameter("bookname");
        String review = request.getParameter("review");
        String[] Types = request.getParameterValues("types");
        String Type = "";
        for(String type : Types){
            Type += type + ", ";
        }
        
        Book b = new Book();
        b.setBookID(BookID);
        b.setAuthor(Author);
        b.setBookName(bookname);
        b.setImg(null);
        b.setReview(review);
        b.setType(Type);
        
        db.insert(b);
        response.sendRedirect("/BookReadingWeb/library");
    }

}
