/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class User extends Human {

    public User() {

    }

    public User(String name, String phone, Date dob, String gender, String account, String password) {
        this.id = newID();
        this.name = name;
        this.phone = phone;
        this.dob = dob;
        this.gender = gender;
        this.account = account;
        this.password = password;
    }

    public User(String name, String phone, String dob, String gender, String account, String password) {
        this.id = newID();
        this.name = name;
        this.phone = phone;
        formatDob(dob);
        this.gender = gender;
        this.account = account;
        this.password = password;
    }

    public User(String id, String name, String phone, Date dob, String gender, String account, String password) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.dob = dob;
        this.gender = gender;
        this.account = account;
        this.password = password;
    }

    public User(String id, String name, String phone, String dob, String gender, String account, String password) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        formatDob(dob);
        this.gender = gender;
        this.account = account;
        this.password = password;
    }

    public User(User u) {
        this(u.getId(), u.getName(), u.getPhone(), u.getDob(), u.getGender(), u.getAccount(), u.getPassword());
    }

    @Override
    public String newID() {
        if (UserDB.getListUser().isEmpty()) 
            return "user100";
        ArrayList<User> listUser =  UserDB.getListUser();
        for (User user : listUser) {
            String numID = user.getId().substring(4);
            String nextID = "user" + (Integer.parseInt(numID)+1);
            if (!isDupplicatedID(nextID)){
                return nextID;
            }
        }
        return null;
    }

    @Override
    public boolean isDupplicatedID(String id) {
        ArrayList<User> listUser =  UserDB.getListUser();
        for (User user : listUser) {
            if (user.getId().equals(id)) return true;
        }
        return false;
    }

    @Override
    public boolean isDupplicatedAccount() {
        ArrayList<User> listUser =  UserDB.getListUser();
        for (User user : listUser) {
            if (user.getAccount().equals(this.account)) return true;
        }
        return false;
    }

    @Override
    public int addNew() {
        return UserDB.addNewUser(this);
    }

    public User login(String acc, String pass) {
        return UserDB.login(acc, pass);
    }
    
    public int getNumOfVaccine(){
        UserDiary ud = ScheduleDB.getDiaryByUser(this.id);
        return ud.getNumOfVaccines();
    }
}
