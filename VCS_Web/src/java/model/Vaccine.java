/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author ADMIN
 */
public class Vaccine {
    String vaccineID;
    Date importDate;
    int amountImport;
    int amountRemain;
    String typeID;
    VaccineType type;

    public Vaccine() {
    }

    public Vaccine(String vaccineID, Date importDate, int amountImport, int amountRemain, String typeID) {
        this.vaccineID = vaccineID;
        this.importDate = importDate;
        this.amountImport = amountImport;
        this.amountRemain = amountRemain;
        this.typeID = typeID;
        this.type = ScheduleDB.getVaccineType(typeID);
    }

    public Vaccine(String vaccineID, Date importDate, int amountImport, int amountRemain, String typeID, VaccineType type) {
        this.vaccineID = vaccineID;
        this.importDate = importDate;
        this.amountImport = amountImport;
        this.amountRemain = amountRemain;
        this.typeID = typeID;
        this.type = type;
    }

    public String getVaccineID() {
        return vaccineID;
    }

    public void setVaccineID(String vaccineID) {
        this.vaccineID = vaccineID;
    }

    public Date getImportDate() {
        return importDate;
    }

    public void setImportDate(Date importDate) {
        this.importDate = importDate;
    }

    public int getAmountImport() {
        return amountImport;
    }

    public void setAmountImport(int amountImport) {
        this.amountImport = amountImport;
    }

    public int getAmountRemain() {
        return amountRemain;
    }

    public void setAmountRemain(int amountRemain) {
        this.amountRemain = amountRemain;
    }

    public String getTypeID() {
        return typeID;
    }

    public void setTypeID(String typeID) {
        this.typeID = typeID;
    }

    public VaccineType getType() {
        return type;
    }

    public void setType(VaccineType type) {
        this.type = type;
    }
    
    
}
