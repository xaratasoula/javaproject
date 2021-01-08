package mainPkg;

import dbConn.ConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Meeting extends Student{

    String meeting;


    public Meeting(String meeting){
        super();
        this.meeting = meeting;
    }
    public static int ArrangeMeeting(String meeting,String am) {
        con = ConnectionProvider.getCon();
        try{
            stmt = con.prepareStatement("update students set meeting = ? where am = ?;");
            stmt.setString(1, meeting);
            stmt.setString(2,am);


            stmt.executeUpdate();
            System.out.println("Meeting submitted.");
            con.close();
            return 1;
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Meeting not Submitted.");
            return 0;
        }
    }
}
