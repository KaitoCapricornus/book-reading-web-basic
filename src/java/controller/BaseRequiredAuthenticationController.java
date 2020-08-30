/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.AccountDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;

/**
 *
 * @author sonnt
 */
public abstract class BaseRequiredAuthenticationController extends HttpServlet {

    private boolean isAuthenticated(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("user");
        if (account != null) {
            return true;
        } else {
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                String user = null, pass = null;
                for (Cookie cooky : cookies) {
                    if (cooky.getName().equals("username")) {
                        user = cooky.getValue();
                        continue;
                    }

                    if (cooky.getName().equals("password")) {
                        pass = cooky.getValue();
                    }

                    if (user != null && pass != null) {
                        AccountDAO db = new AccountDAO();
                        Account reloggedAccount = db.get(user);
                        request.getSession().setAttribute("user", reloggedAccount);
                        request.getSession().setMaxInactiveInterval(30);
                        return true;
                    }
                }
                return false;
            } else {
                return false;
            }
        }
    }

    protected abstract void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

    protected abstract void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (isAuthenticated(request)) {
            processGet(request, response);
        } else {
            response.sendRedirect("/BookReadingWeb/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (isAuthenticated(request)) {
            processPost(request, response);
        } else {
            response.sendRedirect("/BookReadingWeb/login");
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
