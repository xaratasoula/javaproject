package firstTry;

public class Student {
    private  String am;
    private  String pass;
    private  String fullname;
    private  String email;
    private  String orientation;
    private  String supervisor;
    private  String Bsc_thesis;
    private  String start_date;
    private  String prog_language;
    private  String tool;
    private  double grade;

    public String getAm() {
        return am;
    }

    public String getPass() {
        return pass;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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
        return Bsc_thesis;
    }

    public void setBsc_thesis(String bsc_thesis) {
        Bsc_thesis = bsc_thesis;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getProg_language() {
        return prog_language;
    }

    public void setProg_language(String prog_language) {
        this.prog_language = prog_language;
    }

    public String getTool() {
        return tool;
    }

    public void setTool(String tool) {
        this.tool = tool;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public Student(String am) {
        this.am = am;
    }

    public Student(String am, String pass) {
        this.am = am;
        this.pass = pass;
    }
}
