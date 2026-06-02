package job_portal_system.model;
import job_portal_system.model.enums.UserType;



public class Student extends User {
    private String major;
    private int year;
    private double gpa;
    private String resumePath;

    public Student(int userId, String name, String email, String password, 
                   String major, int year, double gpa, String resumePath) {
        super(userId, name, email, password,UserType.Student );
        this.major = major;
        this.year = year;
        this.gpa = gpa;
        this.resumePath = resumePath;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getResumePath() {
        return resumePath;
    }

    public void setResumePath(String resumePath) {
        this.resumePath = resumePath;
    }
}
