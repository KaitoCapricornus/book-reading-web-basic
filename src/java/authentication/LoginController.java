/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package authentication;

import dal.AccountDAO;
import java.io.IOException;
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
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        request.setAttribute("username", username);
        request.setAttribute("password", password);
        request.getRequestDispatcher("/view/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
        AccountDAO db = new AccountDAO();
        Account a = db.get(username);
        if (a == null || !a.getPassword().equals(password)) {
            request.getRequestDispatcher("/view/login.jsp").include(request, response);
            response.getWriter().print("<br/><br/><center><b>Login fail!!!<b></center>");
        } else {
            request.getSession().setAttribute("user", a);
            request.getSession().setMaxInactiveInterval(30);
            if (remember != null && remember.equals("true")) {
                Cookie user = new Cookie("username", username);
                user.setMaxAge(3600 * 24 * 30);
                Cookie pass = new Cookie("password", password);
                pass.setMaxAge(3600 * 24 * 30);
                response.addCookie(pass);
                response.addCookie(user);
            }
            response.sendRedirect("/BookReadingWeb/home");
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
