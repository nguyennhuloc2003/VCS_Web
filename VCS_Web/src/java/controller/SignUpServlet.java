/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Staff;
import model.StaffDB;
import model.User;
import model.UserDB;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "SignUpServlet", urlPatterns = {"/SignUpServlet"})
public class SignUpServlet extends HttpServlet {

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
            out.println("<title>Servlet SignUpServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SignUpServlet at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("signup.jsp").forward(request, response);
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
        String name = request.getParameter("name-input").trim();
        String phone = request.getParameter("phone-input").trim();
        String gender = request.getParameter("gender-input").trim();
        String date = request.getParameter("date-input").trim();
        String username = request.getParameter("username-input").trim();
        String pass = request.getParameter("pass-input").trim();
        String confirm = request.getParameter("confirm-input").trim();
        String role = request.getParameter("role-input").trim();
        
        
        String[] inputArray = {name, phone,gender,date,username,pass,role};
        if(isEmptyInput(inputArray)){
                request.setAttribute("inputError", "Must fill all input!");
                request.getRequestDispatcher("signup.jsp").forward(request, response);
                return;
            } else if(!isConfirmedPassword(pass, confirm)){
                request.setAttribute("inputError", "Confirm incorrect password!");
                request.getRequestDispatcher("signup.jsp").forward(request, response);
                return;
            } else if(!isPhoneNumber(phone)){
                request.setAttribute("inputError", "Invalid phone number!");
                request.getRequestDispatcher("signup.jsp").forward(request, response);
                return;
            }
        
        int id =-1;
        if(role.equals("Customer")){
            User u = new User(name, phone, date, gender, username, pass);
            if (u.isDupplicatedAccount()) {
                request.setAttribute("inputError", "Account is used. Try another one!");
                request.getRequestDispatcher("signup.jsp").forward(request, response);
                return;
            }
            id = u.addNew();
        } else if(role.equals("Staff")){
            Staff s = new Staff(name, phone, date, gender, username, pass);
            if (s.isDupplicatedAccount()) {
                request.getSession().setAttribute("inputError", "Account is used. Try another one!");
                request.getRequestDispatcher("signup.jsp").forward(request, response);
                return;
            }
            id = s.addNew();
        }
        
        request.setAttribute("img", "images/checked.jpg");
        request.setAttribute("notic", "Sign up successfully");
        request.setAttribute("link", "login.jsp");
        request.setAttribute("subLink", "Login");
        if (id==1) 
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

    public static boolean isEmptyInput(String[] s){
        for (int i = 0; i < s.length; i++) {
            if (s[i].isEmpty()) return true;
        }
        return false;
    }
    
    public static boolean isConfirmedPassword(String pass, String confirm){
        if(confirm.equals(pass)) return true;
        return false;
    }
    
    public static boolean isPhoneNumber(String phone){
        String pattern = "^\\+?0[0-9]{9}$";
        if (phone.matches(pattern)) return true;
        return false;
    }
}
