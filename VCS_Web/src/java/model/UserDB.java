/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class UserDB implements DatabaseInfo {

    public static ArrayList<User> getListUser() {
        ArrayList<User> res = new ArrayList<>();
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement ps = con.prepareStatement("select * from users");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                res.add(new User(rs.getString(1), rs.getNString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
        } catch (Exception e) {
        }
        return res;
    }

    public static int addNewUser(User newUser) {
        int res=-1;
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement ps = con.prepareStatement("insert into users values (?,?,?,?,?,?,?) ");
            ps.setString(1, newUser.getId());
            ps.setNString(2, newUser.getName());
            ps.setString(3, newUser.getPhone());
            ps.setDate(4, newUser.getDob());
            ps.setString(5, newUser.getGender());
            ps.setString(6, newUser.getAccount());
            ps.setString(7, newUser.getPassword());
            res = ps.executeUpdate();
            if (res==-1) return res;
            
            res = newDiary(newUser);

        } catch (Exception e) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return res;
    }
    
    public static int newDiary(User newUser){
        int res=-1;
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement ps = con.prepareStatement("insert into userDiary(userID, numOfVaccines) values(?, ?)");
            ps.setString(1, newUser.getId());
            ps.setInt(2, 0);
            res = ps.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return res;
    }

    public static User getUser(String account) {
        User res = new User();
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement ps = con.prepareStatement("Select * from users where account = ?");
            ps.setString(1, account);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                res = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7));
                return res;
            }
        } catch (Exception e) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public static User login(String acc, String pass) {
        User u = getUser(acc);
        if (u != null && u.getPassword().equals(pass)) {
            return u;
        }
        return null;
    }
    
    public static User getUserByID(String userID){
        User res= new User();
        try(Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement ps = con.prepareStatement("Select * from users where userID = ?");
            ps.setString(1, userID);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                res = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7));
                return res;
            }
        } catch (Exception e) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
}
