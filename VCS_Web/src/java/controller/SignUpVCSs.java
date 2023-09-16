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
import model.Staff;
import model.UserDiary;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "SignUpVCSs", urlPatterns = {"/signupVCSs"})
public class SignUpVCSs extends HttpServlet {

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
//        Test
//        Staff nhu = StaffDB.getStaffByID("staff100");
//        request.getSession().setAttribute("staff", nhu);

        ArrayList<Schedule> listSchedule = ScheduleDB.getListSchedule();
        ArrayList<Schedule> copyList = listCopyFrom(listSchedule);
        for (Schedule sc : copyList) {
            if (sc.isVaccinated()) {
                listSchedule.remove(sc);
            }
        }
        request.getSession().setAttribute("listSchedule", listSchedule);
        request.getRequestDispatcher("signupVCSs.jsp").forward(request, response);
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
        Staff s = (Staff) request.getSession().getAttribute("staff");
        ArrayList<Schedule> listSchedule = (ArrayList<Schedule>) request.getSession().getAttribute("listSchedule");
        int resCreate = -1, resDiary = -1;

        for (Schedule schedule : listSchedule) {
            if (!request.getParameter("time-input-" + schedule.getScheduleID()).isEmpty()) {
                UserDiary ud = ScheduleDB.getDiaryByUser(schedule.getUser().getId());
                if (!isBeforeCur(ud.getNextSchedule())) {
                    request.setAttribute("img", "images/unchecked.png");
                    request.setAttribute("link", "signupVCSs.jsp");
                    request.setAttribute("subLink", "Resignup");
                    request.setAttribute("notic", "Can not sign up VCS for userid: "+ud.getUser().getId());
                    request.getRequestDispatcher("notiStaff.jsp").forward(request, response);
                    return;
                }

                Date time = formatDateTime(request.getParameter("time-input-" + schedule.getScheduleID()));
                if(time.after(new Date(System.currentTimeMillis()))) break;
                resCreate = schedule.newCompleteSchedule(s, time);
                resDiary = ScheduleDB.nextSchedule(schedule.getUser().getId(), schedule.getSite().getSiteID(), time);
            }
        }

        if (resCreate == 1 && resDiary == 1) {
            request.setAttribute("img", "images/checked.jpg");
            request.setAttribute("link", "listVCSs");
            request.setAttribute("subLink", "View your VCS");
            request.setAttribute("notic", "Sign up successfully!");
        } else {
            request.setAttribute("img", "images/unchecked.png");
            request.setAttribute("link", "signupVCSs.jsp");
            request.setAttribute("subLink", "Resignup");
            request.setAttribute("notic", "Fail to sign up VCS!");
        }

        request.getRequestDispatcher("notiStaff.jsp").forward(request, response);
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

    public ArrayList<Schedule> listCopyFrom(ArrayList<Schedule> listSche) {
        ArrayList<Schedule> res = new ArrayList<>();
        for (Schedule schedule : listSche) {
            res.add(schedule);
        }
        return res;
    }

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

    public boolean isBeforeCur(Date date) {
        Date cur = new Date(System.currentTimeMillis());
        if (date.before(cur)) {
            return true;
        }
        return false;
    }
}
