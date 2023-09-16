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
import model.Schedule;
import model.ScheduleDB;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "DeleteSchedule", urlPatterns = {"/deleteSchedule"})
public class DeleteSchedule extends HttpServlet {

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
            out.println("<title>Servlet DeleteSchedule</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DeleteSchedule at " + request.getContextPath() + "</h1>");
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
        String scheduleID = request.getParameter("sid");
        Schedule s = ScheduleDB.getScheduleByID(scheduleID);

        if (request.getSession().getAttribute("user") != null) {
            int res = s.deleteSubSchedule();
            if (res == 1) {
                request.setAttribute("img", "images/checked.jpg");
                request.setAttribute("link", "listVCS");
                request.setAttribute("subLink", "View your VCS");
                request.setAttribute("notic", "Delete " + scheduleID + " successfully!");
            } else {
                request.setAttribute("img", "images/unchecked.png");
                request.setAttribute("link", "listVCS");
                request.setAttribute("subLink", "Redelete");
                request.setAttribute("notic", "Fail to delete VCS!");
            }
            request.getRequestDispatcher("notiMain.jsp").forward(request, response);
        } else if (request.getSession().getAttribute("staff") != null) {
            int res = s.deleteCompleteSchedule();
            if (res == 1) {
                request.setAttribute("img", "images/checked.jpg");
                request.setAttribute("link", "listVCSs");
                request.setAttribute("subLink", "View your VCS");
                request.setAttribute("notic", "Delete " + scheduleID + " successfully!");
            } else {
                request.setAttribute("img", "images/unchecked.png");
                request.setAttribute("link", "listVCSs");
                request.setAttribute("subLink", "Redelete");
                request.setAttribute("notic", "Fail to delete VCS!");
            }
            request.getRequestDispatcher("notiStaff.jsp").forward(request, response);
        }
        return;
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
