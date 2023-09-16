/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Schedule;
import model.ScheduleDB;
import static model.ScheduleDB.getScheduleByID;
import static model.ScheduleDB.updateNextSchedule;
import model.Staff;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "UpdateTime", urlPatterns = {"/updateTime"})
public class UpdateTime extends HttpServlet {

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
            out.println("<title>Servlet UpdateTime</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateTime at " + request.getContextPath() + "</h1>");
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
        Staff staff = (Staff) request.getSession().getAttribute("staff");

        ArrayList<Schedule> listS = ScheduleDB.getListScheduleByStaff(staff.getId());
        int res = -1;
        for (Schedule s : listS) {
            if (!request.getParameter("time-input-" + s.getScheduleID()).isEmpty()) {
                Date time = formatDateTime(request.getParameter("time-input-" + s.getScheduleID()));
                res = s.updateTime(time);
                if (s.isLastScheduleUsedOfUser()) {
                    res = updateNextSchedule(s.getUser().getId(), s.getSite().getSiteID(), time);
                }
            }
        }
        if (res == 1) {
            request.setAttribute("img", "images/checked.jpg");
            request.setAttribute("link", "listVCSs");
            request.setAttribute("subLink", "View your VCS");
            request.setAttribute("notic", "Update successfully!");
            request.getRequestDispatcher("notiStaff.jsp").forward(request, response);
        } else {
            request.setAttribute("img", "images/unchecked.jpg");
            request.setAttribute("link", "listVCSs");
            request.setAttribute("subLink", "View your VCS");
            request.setAttribute("notic", "Update fail!");
            request.getRequestDispatcher("notiStaff.jsp").forward(request, response);
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

    public Date formatDateTime(String time) {
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date res = null;
        try {
            res = new Date(sd.parse(time).getTime());
        } catch (Exception ex) {
            throw new RuntimeException("Invalid DOB");
        }
        return res;
    }
}
