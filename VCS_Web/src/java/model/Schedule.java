/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class Schedule {

    SimpleDateFormat sf = new SimpleDateFormat("E, dd-MM-yyyy HH:mm:ss");
    private String scheduleID;
    private VaccineSite site;
    private User user;
    private Staff staff;
    private Date time;
    private String timeString;
    private Date dateInput;
    private String dateInputString;

    public Schedule(VaccineSite site, User user) {
        this.scheduleID = newID();
        this.site = site;
        this.user = user;
    }

    public Schedule(String scheduleID, String siteID, String userID) {
        this.scheduleID = scheduleID;
        this.site = ScheduleDB.getSite(siteID);
        this.user = UserDB.getUserByID(userID);
    }

    public Schedule(String scheduleID, VaccineSite site, User user) {
        this.scheduleID = scheduleID;
        this.site = site;
        this.user = user;
    }

    public Schedule(String scheduleID, VaccineSite site, User user, Staff staff, Date time) {
        this.scheduleID = scheduleID;
        this.site = site;
        this.user = user;
        this.staff = staff;
        this.time = time;
        this.timeString = sf.format(time.getTime());
    }

    public Schedule(String scheduleID, String siteID, String userID, String staffID, Date time) {
        this.scheduleID = scheduleID;
        this.site = ScheduleDB.getSite(siteID);
        this.user = UserDB.getUserByID(userID);
        this.staff = StaffDB.getStaffByID(staffID);
        this.time = time;
        this.timeString = sf.format(time.getTime());
    }
    
    public Schedule(String scheduleID, String siteID, String userID, String staffID, Date time, Date dateInput) {
        this.scheduleID = scheduleID;
        this.site = ScheduleDB.getSite(siteID);
        this.user = UserDB.getUserByID(userID);
        this.staff = StaffDB.getStaffByID(staffID);
        this.time = time;
        this.timeString = sf.format(time.getTime());
        this.dateInput = dateInput;
        this.dateInputString = sf.format(dateInput.getTime());
    }
    
    public Schedule(String scheduleID, String siteID, String userID, String staffID, Timestamp time, Timestamp dateInput) {
        this.scheduleID = scheduleID;
        this.site = ScheduleDB.getSite(siteID);
        this.user = UserDB.getUserByID(userID);
        this.staff = StaffDB.getStaffByID(staffID);
        this.time = new Date(time.getTime());
        this.timeString = sf.format(time.getTime());
        this.dateInput = new Date(dateInput.getTime());
        this.dateInputString = sf.format(dateInput.getTime());
    }

    public String getScheduleID() {
        return scheduleID;
    }

    public void setScheduleID(String scheduleID) {
        this.scheduleID = scheduleID;
    }

    public VaccineSite getSite() {
        return site;
    }

    public void setSite(VaccineSite site) {
        this.site = site;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getTimeString() {
        return timeString;
    }

    public void setTimeString(String timeString) {
        this.timeString = timeString;
    }

    public Date getDateInput() {
        return dateInput;
    }

    public void setDateInput(Date dateInput) {
        this.dateInput = dateInput;
    }

    public String getDateInputString() {
        return dateInputString;
    }

    public void setDateInputString(String dateInputString) {
        this.dateInputString = dateInputString;
    }

    public String newID() {
        if (ScheduleDB.getListSchedule().isEmpty()) {
            return "schedule100";
        }
        ArrayList<Schedule> listSchedule = ScheduleDB.getListSchedule();
        for (Schedule s : listSchedule) {
            String numID = s.getScheduleID().substring(8);
            String nextID = "schedule" + (Integer.parseInt(numID) + 1);
            if (!isDupplicatedID(nextID)) {
                return nextID;
            }
        }
        return null;
    }

    public boolean isDupplicatedID(String id) {
        ArrayList<Schedule> listSchedule = ScheduleDB.getListSchedule();
        for (Schedule s : listSchedule) {
            if (s.getScheduleID().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public int newSubSchedule() {
        return ScheduleDB.newSubSchedule(this);
    }
    
    public int newCompleteSchedule(Staff staff, Date time){
        return ScheduleDB.newCompleteSchedule(this.scheduleID, staff, time);
    }

    public int deleteSubSchedule() {
        return ScheduleDB.deleteSubSchedule(this.scheduleID);
    }

    public int deleteCompleteSchedule() {
        return ScheduleDB.deleteCompleteSchedule(this.scheduleID);
    }
    
    public int updateTime(Date time) {
        return ScheduleDB.updateTime(this.scheduleID, time);
    }
    
    public String getStatus() {
        if (this.staff == null) {
            return "Not yet";
        }
        return "Vaccinated";
    }

    public boolean getCanBeDeletedByUser() {
        if (this.staff == null) {
            return true;
        }
        return false;
    }
    
    public boolean isVaccinated() {
        if (this.staff == null) {
            return false;
        }
        return true;
    }
    
    public boolean isLastScheduleOfUser(){
        String oSID = ScheduleDB.getLastScheduleOfUser(this.user.getId());
        if (this.scheduleID.equalsIgnoreCase(oSID)) 
            return true;
        return false;
    }
    
    public boolean isLastScheduleUsedOfUser(){
        String oSID = ScheduleDB.getLastScheduleUsedOfUser(this.user.getId());
        if (this.scheduleID.equalsIgnoreCase(oSID)) 
            return true;
        return false;
    }
    
    public static String headerSchedule(){
        return "<div class=\"cell\">\n" +
"                                Duration\n" +
"                            </div>\n" +
"                            <div class=\"cell\">\n" +
"                                Location\n" +
"                            </div>\n" +
"                            <div class=\"cell\">\n" +
"                                Vaccine\n" +
"                            </div>\n" +
"                            <div class=\"cell\">\n" +
"                                Staff\n" +
"                            </div>\n" +
"                            <div class=\"cell\">\n" +
"                                Time\n" +
"                            </div>\n" +
"                            <div class=\"cell\">\n" +
"                                Status\n" +
"                            </div>\n" +
"                            <div class=\"cell\">\n" +
"                                Delete\n" +
"                            </div>";
    }

//    public boolean canBeUpdated(){
//        if (this.) {
//            
//        }
//    }
}
