package mainPkg;

import dbConn.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class User {
    private String id;
    private String pass;
    private String fullname;


    public User(String id, String pass) {
        this.id = id;
        this.pass = pass;
    }
    public String getFullname(){ return fullname; }

    public String getId() {
        return id;
    }

    public String getPass() {
        return pass;
    }

    public int login(){
        Connection con;
        PreparedStatement pst1,pst2;

        ResultSet results1 = null, results2 = null;
        try{
            con = ConnectionProvider.getCon();
            pst1 = con.prepareStatement("select hash from users where id =?");
            pst1.setString(1,this.getId());
            results1 = pst1.executeQuery();

            while(results1.next()){
                String userHash = results1.getString("hash"); //original hash
                String password = this.getPass();
                String currentHash = Encryption.makeHash(password);  //current hash

                if(currentHash.equals(userHash)){
                    int status = 0;
                    pst1 = con.prepareStatement("select users.id, supervisors.fullname from users inner join supervisors on users.id = supervisors.id where users.hash =? and users.id=?");
                    pst1.setString(1,userHash);
                    pst1.setString(2,id);
                    results1 = pst1.executeQuery();
                    pst2 = con.prepareStatement("select users.id, students.fullname from users inner join students on users.id = students.am where users.hash =? and users.id=?");
                    pst2.setString(1,userHash);
                    pst2.setString(2,id);
                    results2 = pst2.executeQuery();
                    con.close();


                    if(results1.next()){
                        status = 1;
                        fullname = results1.getString(2);

                    }
                    else if (results2.next()){
                        status = 2;
                        fullname = results2.getString(2);
                    }
                    else { status = 3;}
                    return status;
                }else {
                    con.close();
                    return 4;
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }



}