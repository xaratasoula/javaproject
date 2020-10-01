package mainPkg;

import dbConn.ConnectionProvider;
import dbConn.MD5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Supervisor{
    private final String id;
    private final String pass;
    private final String fullname;
    private final String email;

    public Supervisor(SuperBuilder builder){
        this.id = builder.id;
        this.pass = builder.pass;
        this.fullname = builder.fullname;
        this.email = builder.email;
    }
    public String getID(){return id;}
    public String getPass(){return pass;}
    public String getFullname(){return fullname;}
    public String getEmail(){return email;}

    public int login(){
        Connection con;
        PreparedStatement pst;
        ResultSet results = null;
        try{
            con = ConnectionProvider.getCon();
            pst = con.prepareStatement("select hash,salt from users where id = ?");
            pst.setString(1,this.getID());
            results = pst.executeQuery();

            while(results.next()) {
                byte[] userSalt = results.getBytes("salt");
                String userHash = results.getString("hash");

                String password = this.getPass();
                String currentHash = MD5.makeHash(password, userSalt);

                if (currentHash.equals(userHash)) {
                    int status = 1; //user (supervisor)
                    pst = con.prepareStatement("select * from users\n" +
                            "inner join supervisors on users.id= supervisors.id where hash=? and id =?;");
                    pst.setString(1, userHash);
                    pst.setString(2, id);
                    results = pst.executeQuery();
                    con.close();
                } else {
                    con.close();
                    return 2; //missmatch
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }


    public static class SuperBuilder {
        private final String id;
        private final String pass;
        private String fullname;
        private String email;

        public SuperBuilder(String id,String pass){
            this.id = id;
            this.pass = pass;
        }
        public Supervisor.SuperBuilder fullname(String fullname){
            this.fullname = fullname;
            return this;
        }
        public Supervisor.SuperBuilder email(String email){
            this.email = email;
            return this;
        }
        public Supervisor build(){return new Supervisor(this);}

    }
}