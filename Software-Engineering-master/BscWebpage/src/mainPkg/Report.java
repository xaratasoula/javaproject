package mainPkg;

import dbConn.ConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Report extends Supervisor {

    String am;
    public Report(String am){
        super();
        this.am = am;
    }

    public static ResultSet GetSuperReport(String am){
        ResultSet resultSet;
        con = ConnectionProvider.getCon();
        try{
            stmt = con.prepareStatement("select students.fullname,students.email,orientation,bsc_thesis,start_date,prog_languages,tools,progress,meeting,project,grade from students inner join supervisors on students.supervisor = supervisors.id where students.am = ?");
            stmt.setString(1,am);
            resultSet = stmt.executeQuery();
            con.close();
            return resultSet;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

}