package dbConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SupervisorDAO {
    static Connection con;
    static PreparedStatement stmt;

    public static ResultSet GetAllStudents(){
        ResultSet results;
        con = ConnectionProvider.getCon();
        try{
            stmt = con.prepareStatement("select * from students");
            results = stmt.executeQuery();
            con.close();
            return results;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) throws SQLException {
        ResultSet rs = GetAllStudents();
        System.out.println("AM\t\t\t Full Name\t\t\t\tBachelor Thesis");
        while (true) {
            assert rs != null;
            if (!rs.next()) break;
            try {
                System.out.println(rs.getString("am")+"\t\t"+rs.getString("fullname")+"\t\t\t"+rs.getString("bsc_thesis"));

            }
            catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

}