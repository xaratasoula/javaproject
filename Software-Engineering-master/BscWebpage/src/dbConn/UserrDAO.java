package dbConn;
import mainPkg.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserrDAO {
    static Connection con;
    static PreparedStatement stmt;

    public static ResultSet GetAllStudentInfo(String id){
        ResultSet resultSet;
        con = ConnectionProvider.getCon();
        try{
            stmt = con.prepareStatement("select supervisors.fullname as sfullname,am,students.fullname,students.email,orientation,bsc_thesis,start_date,prog_languages,tools,progress from students inner join supervisors on students.supervisor = supervisors.id where supervisor= ?");
            stmt.setString(1,id);
            resultSet = stmt.executeQuery();
            con.close();
            return resultSet;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    public static ResultSet ShowDates(){
        ResultSet resultSet;
        con = ConnectionProvider.getCon();
        try{
            stmt = con.prepareStatement("select am, fullname, meeting from students where not meeting='-'");
            resultSet = stmt.executeQuery();
            con.close();
            return resultSet;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public static ResultSet GetStudentsWork(String id){
        ResultSet resultSet;
        con = ConnectionProvider.getCon();
        try{
            stmt = con.prepareStatement("select supervisors.fullname,supervisors.email,bsc_thesis,start_date,prog_languages,tools,progress,grade from students inner join supervisors on students.supervisor = supervisors.id where students.am = ?");
            stmt.setString(1,id);
            resultSet = stmt.executeQuery();
            con.close();
            return resultSet;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    public static ResultSet GetSuperReport(String am){
        ResultSet resultSet;
        con = ConnectionProvider.getCon();
        try{
            stmt = con.prepareStatement("select students.fullname,students.email,orientation,bsc_thesis,start_date,prog_languages,tools,progress,grade,meeting from students inner join supervisors on students.supervisor = supervisors.id where students.am = ?");
            stmt.setString(1,am);
            resultSet = stmt.executeQuery();
            con.close();
            return resultSet;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public static int submitGrade(double grade,String am){
        Connection con;
        PreparedStatement stmt;
        con = ConnectionProvider.getCon();
        try{
            stmt = con.prepareStatement("update students set grade = ? where am = ?");
            stmt.setDouble(1,grade);
            stmt.setString(2,am);
            stmt.executeUpdate();
            System.out.println("Grade submitted.");

            con.close();
            return 1;
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Grade not Submitted.");
            return 0;
        }
    }

    public static int ArrangeMeeting(String meeting,String am){
        Connection con;
        PreparedStatement stmt;
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
    public static int Prog(String id){
        Connection con;
        PreparedStatement stmt;
        con = ConnectionProvider.getCon();
        try{
            stmt = con.prepareStatement("update students set project = 'Uploaded' where am=?;");
            stmt.setString(1, id);
            stmt.executeUpdate();
            System.out.println("Progress Updated.");
            con.close();
            return 1;
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Progress Updated.");
            return 0;
        }
    }


}