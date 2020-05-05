package sample.Model;

public class Course {
    private String courseName;
    private String subject;
    private double grade;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public Course(String courseName, String subject, double grade) {
        this.courseName = courseName;
        this.subject = subject;
        this.grade = grade;
    }
}
