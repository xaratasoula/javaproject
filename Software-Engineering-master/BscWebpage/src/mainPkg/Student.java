package mainPkg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dbConn.*;

public class Student extends User{
    private String email;
    private String orientation;
    private String supervisor;
    private String bsc_thesis;
    private String start_date;
    private boolean project;

    public boolean isProject() {
        return project;
    }

    public void setProject(boolean project) {
        this.project = project;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getBsc_thesis() {
        return bsc_thesis;
    }

    public void setBsc_thesis(String bsc_thesis) {
        this.bsc_thesis = bsc_thesis;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getProg_languages() {
        return prog_languages;
    }

    public void setProg_languages(String prog_languages) {
        this.prog_languages = prog_languages;
    }

    public String getTools() {
        return tools;
    }

    public void setTools(String tools) {
        this.tools = tools;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public String getMeeting() {
        return meeting;
    }

    public void setMeeting(String meeting) {
        this.meeting = meeting;
    }

    private String prog_languages;
    private String tools;
    private double grade;
    private String progress;
    private String meeting;

    public Student(){
        super();
    }
    public Student(String am, String password){
        super(am,password);
    }



    public static ResultSet GetStudentsWork(String id){
        ResultSet resultSet;
        con = ConnectionProvider.getCon();
        try{
            stmt = con.prepareStatement("select supervisors.fullname,supervisors.email,bsc_thesis,start_date,prog_languages,tools,progress,meeting,grade from students inner join supervisors on students.supervisor = supervisors.id where students.am = ?");
            stmt.setString(1,id);
            resultSet = stmt.executeQuery();
            con.close();
            return resultSet;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public static int Prog(String id) {
        Connection con;
        PreparedStatement stmt;
        con = ConnectionProvider.getCon();
        try {
            stmt = con.prepareStatement("update students set project = 'Uploaded' where am=?;");
            stmt.setString(1, id);
            stmt.executeUpdate();
            System.out.println("Progress Updated.");
            con.close();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Progress Updated.");
            return 0;
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
}
