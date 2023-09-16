/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author ADMIN
 */
public abstract class Human {
    protected String id;
    protected String name;
    protected String phone;
    protected Date dob;
    protected String gender;
    protected String account;
    protected String password;
    
    
    public abstract String newID();
    public abstract boolean isDupplicatedID(String id);    
    public abstract boolean isDupplicatedAccount();
    public abstract int addNew();
    
    public void formatDob(String dob) {
        SimpleDateFormat sd= new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.dob = new Date(sd.parse(dob).getTime());
        } catch (Exception ex) {
            throw new RuntimeException("Invalid DOB");
        }
    }
    
    @Override
    public String toString() {
        return id + " | " + name + " | " + phone + " | " + dob + " | " + gender + " | " + account + " | " + password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDob() {
        return dob;
    }
    
    public String getDobString() {
        SimpleDateFormat sd= new SimpleDateFormat("yyyy-MM-dd");
        return sd.format(this.dob);
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
