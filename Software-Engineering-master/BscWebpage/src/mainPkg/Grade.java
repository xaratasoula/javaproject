package mainPkg;

import dbConn.ConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Grade extends Report{
    double grade;
    String am;
    public Grade(double grade,String am){
        super(am);
        this.grade = grade;

    }
    public static int submitGrade(double grade,String am){
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
}