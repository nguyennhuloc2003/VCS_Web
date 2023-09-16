package model;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public interface DatabaseInfo {
    public static String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static String dbURL="jdbc:sqlserver://localhost:1433;databaseName=VCSManage;";
    public static String userDB="sa";
    public static String passDB="123456";
    public static Connection getConnect(){
        try {
            Context initContext = new InitialContext();
            Context envContext  = (Context)initContext.lookup("java:/comp/env");
            DataSource ds = (DataSource)envContext.lookup("jdbc/mydb");
            return ds.getConnection();
        } catch (Exception ex) {
            Logger.getLogger(DatabaseInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
