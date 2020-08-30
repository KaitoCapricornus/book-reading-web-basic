/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.BookDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Book;

/**
 *
 * @author dinht
 */
public class SearchController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String BookName = request.getParameter("bookname") == null ? "" : request.getParameter("bookname");
        String[] x = {};
        String[] types = request.getParameterValues("types") == null ? x : request.getParameterValues("types");

        String sql = "";
        String sql_BookName = "";
        String sql_Types = "";
        if (!BookName.equals("")) {
            sql_BookName = "select * from Books where BookName like '%" + BookName + "%'";
        }
        if (types != x) {
            sql_Types = "select * from Books where ";
            for (String type : types) {
                sql_Types += "Type like '%" + type + "%' ";
                if (!type.equals(types[types.length - 1])) {
                    sql_Types += "or ";
                }
            }
        }
        if (!sql_BookName.equals("") && !sql_Types.equals("")) {
            sql = sql_BookName + " intersect " + sql_Types;
        } else if (sql_BookName.equals("") && !sql_Types.equals("")) {
            sql = sql_Types;
        } else if (!sql_BookName.equals("") && sql_Types.equals("")) {
            sql = sql_BookName;
        }
        
        BookDAO db = new BookDAO();
        ArrayList<Book> books = db.search(sql);
        
        request.setAttribute("books", books);
        request.setAttribute("bookname", BookName);
        request.setAttribute("types", Arrays.asList(types));
        request.getRequestDispatcher("/view/search.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
