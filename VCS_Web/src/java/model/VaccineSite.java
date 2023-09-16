/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class VaccineSite {
    SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
    String siteID;
    Date dateFrom;
    String dateFromString;
    Date dateTo;
    String dateToString;
    Place place;
    Vaccine vaccine;

    public VaccineSite() {
    }

    public VaccineSite(String siteID, Date dateFrom, Date dateTo, Place place, Vaccine vaccine) {
        this.siteID = siteID;
        this.dateFrom = dateFrom;
        this.dateFromString = sf.format(dateFrom);
        this.dateTo = dateTo;
        this.dateToString = sf.format(dateTo);
        this.place = place;
        this.vaccine = vaccine;
    }

    public VaccineSite(String siteID, Date dateFrom, Date dateTo, String placeID, String vaccineID) {
        this.siteID = siteID;
        this.dateFrom = dateFrom;
        this.dateFromString = sf.format(dateFrom);
        this.dateTo = dateTo;
        this.dateToString = sf.format(dateTo);
        this.place = ScheduleDB.getPlace(placeID);
        this.vaccine = ScheduleDB.getVaccine(vaccineID);
    }
    
    public String getSiteID() {
        return siteID;
    }

    public void setSiteID(String siteID) {
        this.siteID = siteID;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateFromString() {
        return dateFromString;
    }

    public void setDateFromString(String dateFromString) {
        this.dateFromString = dateFromString;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public String getDateToString() {
        return dateToString;
    }

    public void setDateToString(String dateToString) {
        this.dateToString = dateToString;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }
    
    public boolean isOutOfDate(){
        Date current = new Date(System.currentTimeMillis());
        if (this.dateTo.before(current)) return true;
        return false;
    }
    
    public boolean isNotEnoughVaccine(){
        if (this.vaccine.getAmountRemain()<=0) return true;
        return false;
    }

    @Override
    public String toString() {
        return siteID + " | " + dateFromString + "-" + dateToString + " | " + place + " | " + vaccine;
    }
    
    public boolean isInArray(ArrayList<Schedule> list){
        for (Schedule s : list) {
            if (this.siteID.equals(s.getSite().getSiteID())) return true;
        }
        return false;
    }
}
