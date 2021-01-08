package mainPkg;

import dbConn.ConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Supervisor extends User {
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Supervisor(){
        super();
    }
    public Supervisor(String id, String password){
        super(id,password);
    }

    public static ResultSet GetAllStudentInfo(String id){
        ResultSet resultSet;
        con = ConnectionProvider.getCon();
        try{
            stmt = con.prepareStatement("select supervisors.fullname as sfullname,am,students.fullname,students.email,orientation,bsc_thesis from students inner join supervisors on students.supervisor = supervisors.id where supervisor= ?");
            stmt.setString(1,id);
            resultSet = stmt.executeQuery();
            con.close();
            return resultSet;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }



}