/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ADMIN
 */
public class Counter {
    private int counter;
    
    public Counter() {
        try(Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement ps = con.prepareStatement("select counterVal from Counter");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                this.counter = rs.getInt(1);
            }
        } catch (Exception e) {
        }
        
    }

    public Counter(int counter) {
        this.counter = counter;
    }

    public int getCounter() {
        return ++counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    @Override
    public String toString() {
        return counter+"";
    }
    
    public void save(){
        try(Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement ps = con.prepareStatement("update Counter set counterVal = ?");
            ps.setInt(1, this.counter);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
