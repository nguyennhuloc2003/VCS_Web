/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Schedule;
import model.ScheduleDB;
import model.User;
import model.VaccineSite;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "SignUpVCS", urlPatterns = {"/signupVCS"})
public class SignUpVCS extends HttpServlet {

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
            out.println("<title>Servlet SignUpVCS</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SignUpVCS at " + request.getContextPath() + "</h1>");
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
        User u = (User) request.getSession().getAttribute("user");

        Date current = new Date(System.currentTimeMillis());
        Date nextSchedule = ScheduleDB.getNextScheduleByUser(u.getId());
        
        if (nextSchedule !=null && nextSchedule.after(current)) {
            request.setAttribute("img", "images/unchecked.png");
            request.setAttribute("link", "aboutMain.jsp");
            request.setAttribute("subLink", "About VCS Web");
            request.setAttribute("notic", "Your next schedule hasn't arrived yet");
            request.getRequestDispatcher("notiMain.jsp").forward(request, response);
            return;
        }
        
        
        ArrayList<VaccineSite> listSite = ScheduleDB.getListVSite();
        ArrayList<Schedule> userSchedule = ScheduleDB.getListScheduleByUser(u.getId());
        ArrayList<VaccineSite> copyList = listCopyFrom(listSite);
        
        for (VaccineSite s : copyList) {
            if (s.isOutOfDate() || s.isInArray(userSchedule) || s.isNotEnoughVaccine()) {
                listSite.remove(s);
            }
        }
        request.getSession().setAttribute("listSite", listSite);
        request.getRequestDispatcher("signupVCS.jsp").forward(request, response);
//        }
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
        String siteID = request.getParameter("siteID");
        VaccineSite site = ScheduleDB.getSite(siteID);
        User u = (User)request.getSession().getAttribute("user");
        Schedule schedule = new Schedule(site, u);
        
        int res = schedule.newSubSchedule();
        
        
        if (res == 1) {
            request.setAttribute("img", "images/checked.jpg");
            request.setAttribute("link", "listVCS");
            request.setAttribute("subLink", "View your VCS");
            request.setAttribute("notic", "Sign up successfully! Schedule ID: "+ schedule.getScheduleID());
        } else{
            request.setAttribute("img", "images/unchecked.png");
            request.setAttribute("link", "signupVCS.jsp");
            request.setAttribute("subLink", "Resignup");
            request.setAttribute("notic", "Fail to sign up VCS!");
        }

        request.getRequestDispatcher("notiMain.jsp").forward(request, response);
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

    public ArrayList<VaccineSite> listCopyFrom(ArrayList<VaccineSite> listSite) {
        ArrayList<VaccineSite> res = new ArrayList<>();
        for (VaccineSite vaccineSite : listSite) {
            res.add(vaccineSite);
        }
        return res;
    }
     
    
//    public Date nextSchedule(String userID, String siteID){
//        
//    }
}
