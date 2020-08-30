/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package authentication;

import dal.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;

/**
 *
 * @author dinht
 */
public class RegisterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/view/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String cfpassword = request.getParameter("cfpassword");
        String type = request.getParameter("type");
        AccountDAO db = new AccountDAO();
        boolean isRegisted = db.isRegisted(username);
        if (isRegisted) {
            request.getRequestDispatcher("/view/register.jsp").include(request, response);
            response.getWriter().print("<br/><br/><center><b>Username is already Registed!!! Please use another Username!!!<b></center>");
        } else if (!password.equals(cfpassword)) {
            request.getRequestDispatcher("/view/register.jsp").include(request, response);
            response.getWriter().print("<br/><br/><center><b>\"Password\" and \"Confirm Password\" must be the same!!!<b></center>");
        } else {
            Account a = new Account();
            a.setUsername(username);
            a.setPassword(password);
            a.setType(type);
            db.insert(a);
            response.sendRedirect("/BookReadingWeb/login?username=" + username + "&password=" + password);
        }

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
