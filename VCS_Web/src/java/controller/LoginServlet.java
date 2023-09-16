/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Staff;
import model.StaffDB;
import model.User;
import model.UserDB;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        request.getRequestDispatcher("login.jsp").forward(request, response);
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
        String uName = request.getParameter("username-login").trim();
        String password = request.getParameter("password-login").trim();
        String role = request.getParameter("role-login").trim();
        
//        remember me?
        String remember = request.getParameter("remember");
        if (remember.equals("on")) {
            response.addCookie(new Cookie("account", uName));
            response.addCookie(new Cookie("password", password));
            response.addCookie(new Cookie("role", role));
        }
//        end remember me
        
        request.setAttribute("role", role);
        if (role.equals("Customer")) {
            User u = new User().login(uName, password);
            if (u != null) {
                request.getSession().setAttribute("user", u);
                request.getRequestDispatcher("main.jsp").forward(request, response);
                return;
            }
        } else if (role.equals("Staff")) {
            Staff s = new Staff().login(uName, password);
            if (s != null) {
                request.getSession().setAttribute("staff", s);
                request.getRequestDispatcher("mainStaff.jsp").forward(request, response);
                return;
            }
        } else if (uName.equals("manager") && password.equals("123456")) {
                request.getSession().setAttribute("manager", "manager/123456");
                request.getRequestDispatcher("mainManage.jsp").forward(request, response);
                return;
        }

        request.setAttribute("img", "images/unchecked.png");
        request.setAttribute("notic", "Login fail. Username or password is wrong!");
        request.setAttribute("link", "login.jsp");
        request.setAttribute("subLink", "Relogin");
        request.getRequestDispatcher("noti.jsp").forward(request, response);
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
