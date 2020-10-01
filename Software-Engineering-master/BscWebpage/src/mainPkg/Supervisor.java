package mainPkg;

public class Supervisor {
    private final String id;
    private final String fullname;
    private final String email;

    public Supervisor(SuperBuilder builder){
        this.id = builder.id;
        this.fullname = builder.fullname;
        this.email = builder.email;
    }
    public static class SuperBuilder{
        private final String id;
        private String fullname;
        private String email;

        public SuperBuilder(String id){
            this.id = id;
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
