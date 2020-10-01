package mainPkg;

public class Student {
    private final String am;
    private final String pass;
    private final String fullname;
    private final String email;
    private final String orientation;
    private final int supervisor;
    private final String Bsc_thesis;
    private final String start_date;
    private final String prog_language;
    private final String tool;
    private final double grade;

    public Student(Builder builder){
        this.am = builder.am;
        this.fullname = builder.fullname;
        this.email = builder.email;
        this.orientation = builder.orientation;
        this.supervisor = builder.supervisor;
        this.Bsc_thesis = builder.Bsc_thesis;
        this.start_date = builder.start_date;
        this.prog_language = builder.prog_language;
        this.tool = builder.tool;
        this.grade = builder.grade;
    }

    public static class Builder{
        private final String am;
        private final String fullname;
        private final String email;
        private String orientation;
        private int supervisor;
        private String Bsc_thesis;
        private String start_date;
        private String prog_language;
        private String tool;
        private double grade;

        public Builder(String am, String fullname, String email){
            this.am = am;
            this.fullname = fullname;
            this.email = email;
        }
        public Builder orientation(String orientation){
            this.orientation = orientation;
            return this;
        }
        public Builder supervisor(int supervisor){
            this.supervisor = supervisor;
            return this;
        }
        public Builder bsc_thesis(String bsc_thesis){
            this.Bsc_thesis = bsc_thesis;
            return this;
        }
        public Builder start_date(String start_date){
            this.start_date = start_date;
            return this;
        }
        public Builder prog_language(String prog_language){
            this.prog_language = prog_language;
            return this;
        }
        public Builder tool(String tool){
            this.tool = tool;
            return this;
        }
        public Builder grade(double grade){
            this.grade = grade;
            return this;
        }

        public Student build(){
            return new Student(this);
        }
    }
}
