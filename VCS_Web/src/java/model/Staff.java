/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author ADMIN
 */
public class Staff extends Human {

    public Staff() {

    }

    public Staff(String name, String phone, Date dob, String gender, String account, String password) {
        this.id = newID();
        this.name = name;
        this.phone = phone;
        this.dob = dob;
        this.gender = gender;
        this.account = account;
        this.password = password;
    }

    public Staff(String name, String phone, String dob, String gender, String account, String password) {
        this.id = newID();
        this.name = name;
        this.phone = phone;
        formatDob(dob);
        this.gender = gender;
        this.account = account;
        this.password = password;
    }

    public Staff(String id, String name, String phone, String dob, String gender, String account, String password) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        formatDob(dob);
        this.gender = gender;
        this.account = account;
        this.password = password;
    }

    public Staff(String id, String name, String phone, Date dob, String gender, String account, String password) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.dob = dob;
        this.gender = gender;
        this.account = account;
        this.password = password;
    }

    public Staff(Staff s) {
        this(s.getId(), s.getName(), s.getPhone(), s.getDob(), s.getGender(), s.getAccount(), s.getPassword());
    }

    @Override
    public String newID() {
        if (StaffDB.getListStaff().isEmpty()) {
            return "staff100";
        }
        ArrayList<Staff> listStaff = StaffDB.getListStaff();
        for (Staff staff : listStaff) {
            String numID = staff.getId().substring(5);
            String nextID = "staff" + (Integer.parseInt(numID) + 1);
            if (!isDupplicatedID(nextID)) {
                return nextID;
            }
        }
        return null;
    }

    @Override
    public boolean isDupplicatedID(String id) {
        ArrayList<Staff> listStaff = StaffDB.getListStaff();
        for (Staff staff : listStaff) {
            if (staff.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isDupplicatedAccount() {
        ArrayList<Staff> listStaff = StaffDB.getListStaff();
        for (Staff staff : listStaff) {
            if (staff.getAccount().equals(this.id)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int addNew() {
        return StaffDB.addNewStaff(this);
    }

    public Staff login(String acc, String pass) {
        return StaffDB.login(acc, pass);
    }

    public static void main(String[] args) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 15);
        Date date = new Date(cal.getTime().getTime());
        System.out.println("SQL date: "+ sf.format(date));
    }
}
