package dbConn;
import java.sql.*;
public class ConnectionProvider implements Provider {
    static Connection con = null;
    public static Connection getCon(){
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(connURL,username,password) ;
            System.out.println("connection established");
        } catch (Exception e){
            System.out.println("connection not established");
            e.printStackTrace();
        }
        return con;
    }
}