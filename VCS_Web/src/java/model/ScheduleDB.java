/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.function.Predicate;

/**
 *
 * @author ADMIN
 */
public class ScheduleDB implements DatabaseInfo {

//    I. PlaceDB
    public static Place getPlace(String placeID) {
        Place p = null;
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement ps = con.prepareStatement("select loca from place where placeID= ?");
            ps.setString(1, placeID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                p = new Place(placeID, rs.getNString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

//    End placeDB
//    II. VaccineTypeDB
    public static VaccineType getVaccineType(String typeID) {
        VaccineType t = null;
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement ps = con.prepareStatement("select typename, productcompany, restperiod from vaccinetype where typeid = ?");
            ps.setString(1, typeID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                t = new VaccineType(typeID, rs.getString(1), rs.getString(2), rs.getInt(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }
//    End VaccineTypeDB

//    III. VaccineDB
    public static Vaccine getVaccine(String vaccineID) {
        Vaccine v = null;
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement ps = con.prepareStatement("select importdate, amountimport, amountremain, typeid from vaccine where vaccineid = ?");
            ps.setString(1, vaccineID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                v = new Vaccine(vaccineID, rs.getDate(1), rs.getInt(2), rs.getInt(3), rs.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return v;
    }
//    End VaccineDB

//    IV. SiteID
    public static VaccineSite getSite(String siteID) {
        VaccineSite s = null;
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement ps = con.prepareStatement("select dateFrom, dateTo, placeID, vaccineID from vaccinesite where siteID = ?");
            ps.setString(1, siteID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                s = new VaccineSite(siteID, rs.getDate(1), rs.getDate(2), rs.getString(3), rs.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    public static ArrayList<VaccineSite> getListVSite() {
        ArrayList<VaccineSite> res = new ArrayList<>();
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement ps = con.prepareStatement("select * from vaccinesite");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                res.add(new VaccineSite(rs.getString(1), rs.getDate(2), rs.getDate(3), rs.getString(4), rs.getString(5)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

//  End SiteDB
//    V. ScheduleDB
    public static int newSubSchedule(Schedule s) {
        int res = -1;
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement ps = con.prepareStatement("insert into schedule(scheduleID, siteID, userID) values(?,?,?)");
            ps.setString(1, s.getScheduleID());
            ps.setString(2, s.getSite().getSiteID());
            ps.setString(3, s.getUser().getId());
            res = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public static int newCompleteSchedule(String scheduleID, Staff staff, Date time) {
        Date cur = new Date(System.currentTimeMillis());
        int res = -1;
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement ps = con.prepareStatement("Update Schedule set staffID = ?, time = ?, dateInput = ? where scheduleID = ?");
            ps.setString(1, staff.getId());
            ps.setTimestamp(2, new Timestamp(time.getTime()));
            ps.setTimestamp(3, new Timestamp(cur.getTime()));
            ps.setString(4, scheduleID);
            res = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public static int updateTime(String scheduleID, Date time) {
        Date cur = new Date(System.currentTimeMillis());
        int res = -1;
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement ps = con.prepareStatement("Update Schedule set time = ?, dateInput = ? where scheduleID = ?");
            ps.setTimestamp(1, new Timestamp(time.getTime()));
            ps.setTimestamp(2, new Timestamp(cur.getTime()));
            ps.setString(3, scheduleID);
            res = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

//    public static ArrayList<Schedule> getListSchedule() {
//        ArrayList<Schedule> res = new ArrayList<>();
//        try ( Connection con = DatabaseInfo.getConnect()) {
//            PreparedStatement ps = con.prepareStatement("select * from schedule");
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                if (rs.getString(4) == null) {
//                    res.add(new Schedule(rs.getString(1), rs.getString(2), rs.getString(3)));
//                } else {
//                    res.add(new Schedule(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getDate(6)));
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return res;
//    }
    
    public static ArrayList<Schedule> getListSchedule() {
        ArrayList<Schedule> res = new ArrayList<>();
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement ps = con.prepareStatement("select * from schedule");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString(4) == null) {
                    res.add(new Schedule(rs.getString(1), rs.getString(2), rs.getString(3)));
                } else {
                    res.add(new Schedule(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getTimestamp(5), rs.getTimestamp(6)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public static ArrayList<Schedule> getListScheduleByUser(String userID) {
        ArrayList<Schedule> res = new ArrayList<>();
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement ps = con.prepareStatement("select * from schedule where userID=?");
            ps.setString(1, userID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString(4) == null) {
                    res.add(new Schedule(rs.getString(1), rs.getString(2), rs.getString(3)));
                } else {
                    res.add(new Schedule(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getTimestamp(5), rs.getTimestamp(6)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public static ArrayList<Schedule> getListScheduleByStaff(String staffID) {
        ArrayList<Schedule> res = new ArrayList<>();
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement ps = con.prepareStatement("select * from schedule where staffID=?");
            ps.setString(1, staffID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString(4) == null) {
                    res.add(new Schedule(rs.getString(1), rs.getString(2), rs.getString(3)));
                } else {
                    res.add(new Schedule(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getTimestamp(5), rs.getTimestamp(6)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public static Schedule getScheduleByID(String scheduleID) {
        Schedule res = null;
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement ps = con.prepareStatement("select * from schedule where scheduleID=?");
            ps.setString(1, scheduleID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                if (rs.getString(4) == null) {
                    res = new Schedule(rs.getString(1), rs.getString(2), rs.getString(3));
                } else {
                    res = new Schedule(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getTimestamp(5), rs.getTimestamp(6));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public static int deleteSubSchedule(String scheduleID) {
        int res = -1;
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement ps = con.prepareStatement("delete from Schedule where scheduleID = ?");
            ps.setString(1, scheduleID);
            res = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public static int deleteCompleteSchedule(String scheduleID) {
        int res = -1;
        try ( Connection con = DatabaseInfo.getConnect()) {
            Schedule s = getScheduleByID(scheduleID);
            if (s.isLastScheduleUsedOfUser()){
                UserDiary ud = getDiaryByUser(s.getUser().getId());
                updatePreviousSchedule(s.getUser().getId(), s.getSite().getSiteID(), ud.getNextSchedule());
            } else {
                subNumOfVaccine(s.getUser().getId());
            }

            PreparedStatement ps = con.prepareStatement("update Schedule set staffID = NULL, time = NULL, dateInput = NULL where scheduleID = ?");
            ps.setString(1, scheduleID);
            res = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

//    public static ArrayList<Schedule> listAllSchedule() {
//        ArrayList<Schedule> res = new ArrayList<>();
//        try ( Connection con = DatabaseInfo.getConnect()) {
//            PreparedStatement ps = con.prepareStatement("select * from Schedule");
//            ResultSet rs = ps.executeQuery();
//            while(rs.next()){
//                res.add(new Schedule(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5)));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return res;
//    }
    public static ArrayList<Schedule> searchSchedule(Predicate<Schedule> pre) {
        ArrayList<Schedule> list = getListSchedule();
        ArrayList<Schedule> res = new ArrayList<Schedule>();
        for (Schedule s : list) {
            if (pre.test(s)) {
                res.add(s);
            }
        }
        return res;
    }

    public static String getLastScheduleOfUser(String userID){
        String scheduleID = null;
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement ps = con.prepareStatement("select top 1 * from Schedule where userID = ? order by scheduleID desc");
            ps.setString(1, userID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                scheduleID = rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scheduleID;
    }
    
    public static String getLastScheduleUsedOfUser(String userID){
        String scheduleID = null;
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement ps = con.prepareStatement("select top 1 * from Schedule where userID = ? and staffID is not null order by scheduleID desc");
            ps.setString(1, userID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                scheduleID = rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scheduleID;
    }
    
//    End ScheduleDB
//      VI. DiaryDB
    public static int nextSchedule(String userID, String siteID, Date vaccineDate) {
        VaccineSite vs = ScheduleDB.getSite(siteID);
        int restPeriod = vs.getVaccine().getType().getRestPeriod();
        Date nextSchedule = addPeriod(vaccineDate, restPeriod);
        int res = -1;

        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement getUserStm = con.prepareStatement("Select nextSchedule, numOfVaccines from userDiary where userID = ?");
            getUserStm.setString(1, userID);
            ResultSet rs = getUserStm.executeQuery();
            UserDiary ud = new UserDiary();
            if (rs.next()) {
                ud = new UserDiary(userID, rs.getDate(1), rs.getInt(2));
            }

            PreparedStatement setDiaryStm = con.prepareStatement("update userDiary "
                    + "set nextSchedule = ?, numOfVaccines = ? "
                    + "where userID = ? ");
            setDiaryStm.setDate(1, nextSchedule);
            setDiaryStm.setInt(2, ud.getNumOfVaccines() + 1);
            setDiaryStm.setString(3, userID);
            res = setDiaryStm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return res;
    }

    public static int updateNextSchedule(String userID, String siteID, Date vaccineDate) {
        VaccineSite vs = ScheduleDB.getSite(siteID);
        int restPeriod = vs.getVaccine().getType().getRestPeriod();
        Date nextSchedule = addPeriod(vaccineDate, restPeriod);
        int res = -1;

        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement setDiaryStm = con.prepareStatement("update userDiary set nextSchedule = ? where userID = ? ");
            setDiaryStm.setDate(1, nextSchedule);
            setDiaryStm.setString(2, userID);
            res = setDiaryStm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public static int updatePreviousSchedule(String userID, String siteID, Date curSchedule) {
        VaccineSite vs = ScheduleDB.getSite(siteID);
        int restPeriod = vs.getVaccine().getType().getRestPeriod();
        Date previousSchedule = subtractPeriod(curSchedule, restPeriod);
        int res = -1;
        UserDiary ud = new UserDiary();

        try ( Connection con = DatabaseInfo.getConnect()) {
            if (getDiaryByUser(userID) != null) {
                ud = getDiaryByUser(userID);
            } else {
                return res;
            }

            PreparedStatement setDiaryStm = con.prepareStatement("update userDiary "
                    + "set nextSchedule = ?, numOfVaccines = ? "
                    + "where userID = ? ");
            setDiaryStm.setDate(1, previousSchedule);
            setDiaryStm.setInt(2, ud.getNumOfVaccines() - 1);
            setDiaryStm.setString(3, userID);
            res = setDiaryStm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
    
    public static int subNumOfVaccine(String userID) {
        int res = -1;
        UserDiary ud = new UserDiary();

        try ( Connection con = DatabaseInfo.getConnect()) {
            if (getDiaryByUser(userID) != null) {
                ud = getDiaryByUser(userID);
            } else {
                return res;
            }

            PreparedStatement setDiaryStm = con.prepareStatement("update userDiary "
                    + "set numOfVaccines = ? "
                    + "where userID = ? ");
            setDiaryStm.setInt(1, ud.getNumOfVaccines() - 1);
            setDiaryStm.setString(2, userID);
            res = setDiaryStm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public static UserDiary getDiaryByUser(String userID) {
        UserDiary ud = null;
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement getUserStm = con.prepareStatement("Select nextSchedule, numOfVaccines from userDiary where userID = ?");
            getUserStm.setString(1, userID);
            ResultSet rs = getUserStm.executeQuery();
            if (rs.next()) {
                ud = new UserDiary(userID, rs.getDate(1), rs.getInt(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ud;
    }

    public static Date getNextScheduleByUser(String userID) {
        Date res = null;
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement ps = con.prepareStatement("Select nextSchedule from userDiary where userID = ?");
            ps.setString(1, userID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                res = rs.getDate(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

//    End DiaryDB
//    VII. Sub Function
    public static Date addPeriod(Date date, int periodDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, periodDate);
        Date res = new Date(cal.getTimeInMillis());
        return res;
//        Date d = new Date(System.currentTimeMillis())
    }

    public static Date subtractPeriod(Date date, int periodDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, -periodDate);
        Date res = new Date(cal.getTimeInMillis());
        return res;
//        Date d = new Date(System.currentTimeMillis())
    }
}
