/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author ADMIN
 */
public class UserDiary {
    private User user;
    private Date nextSchedule;
    private Timestamp nextScheduleTS;
    private int numOfVaccines;

    public UserDiary(){
        
    }
    
    public UserDiary(String userID){
        
    }
    
    public UserDiary(String userID, Date nextSchedule, int numOfVaccines){
        this.user = UserDB.getUserByID(userID);
        this.nextSchedule = nextSchedule;
        this.numOfVaccines = numOfVaccines;
    }
    
    public UserDiary(String userID, Timestamp nextSchedule, int numOfVaccines){
        this.user = UserDB.getUserByID(userID);
        this.nextSchedule = new Date(nextSchedule.getTime()) ;
        this.nextScheduleTS = nextSchedule;
        this.numOfVaccines = numOfVaccines;
    }
    
    public UserDiary(User user, Date nextSchedule, int numOfVaccines) {
        this.user = user;
        this.nextSchedule = nextSchedule;
        this.numOfVaccines = numOfVaccines;
    }
    
    public UserDiary(User user, Timestamp nextSchedule, int numOfVaccines) {
        this.user = user;
        this.nextSchedule = new Date(nextSchedule.getTime()) ;
        this.nextScheduleTS = nextSchedule;
        this.numOfVaccines = numOfVaccines;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getNextSchedule() {
        if (nextSchedule==null) return new Date(System.currentTimeMillis()-1);
        return nextSchedule;
    }

    public void setNextSchedule(Date nextSchedule) {
        this.nextSchedule = nextSchedule;
    }

    public int getNumOfVaccines() {
        return numOfVaccines;
    }

    public void setNumOfVaccines(int numOfVaccines) {
        this.numOfVaccines = numOfVaccines;
    }

    public Timestamp getNextScheduleTS() {
        return nextScheduleTS;
    }

    public void setNextScheduleTS(Timestamp nextScheduleTS) {
        this.nextScheduleTS = nextScheduleTS;
    }
    
    
}
