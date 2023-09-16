/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class StaffDB implements DatabaseInfo{
    public static ArrayList<Staff> getListStaff(){
        ArrayList<Staff> res = new ArrayList<>();
        try(Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement ps = con.prepareStatement("select * from staff");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                res.add(new Staff(rs.getString(1), rs.getNString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
        } catch (Exception e) {
        }
        return res;
    }
     public static int addNewStaff(Staff newStaff){
        int res =-1;
        try(Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement ps = con.prepareStatement("insert into staff values (?,?,?,?,?,?,?) ");
            ps.setString(1, newStaff.getId());
            ps.setNString(2, newStaff.getName());
            ps.setString(3, newStaff.getPhone());
            ps.setDate(4, newStaff.getDob());
            ps.setString(5, newStaff.getGender());
            ps.setString(6, newStaff.getAccount());
            ps.setString(7, newStaff.getPassword());
           
            
            res = ps.executeUpdate();
            
        } catch (Exception e) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return res;
    }
     
    public static Staff getStaff(String account){
        Staff res= new Staff();
        try(Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement ps = con.prepareStatement("Select * from staff where account = ?");
            ps.setString(1, account);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                res = new Staff(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7));
                return res;
            }
        } catch (Exception e) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
    public static Staff getStaffByID(String staffID){
        Staff res= new Staff();
        try(Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement ps = con.prepareStatement("Select * from staff where staffid = ?");
            ps.setString(1, staffID);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                res = new Staff(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7));
                return res;
            }
        } catch (Exception e) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
    public static Staff login(String acc, String pass) {
        Staff s = getStaff(acc);
        if(s!=null && s.password.equals(pass)) return s;
        return null;
    }
}
