package sample.Model;

public class Course {
    private String courseName;
    private String subject;
    private int grade;
    private String isRegistered;

    public String getIsRegistered() {
        return isRegistered;
    }

    public void setIsRegistered(String isRegistered) {
        this.isRegistered = isRegistered;
    }

    public Course(String courseName, String subject, int grade, String isRegistered) {
        this.courseName = courseName;
        this.subject = subject;
        this.grade = grade;
        this.isRegistered = isRegistered;
    }

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

    public void setGrade(int grade) {
        this.grade = grade;
    }
    

    public Course() {
        this.courseName = courseName;
        this.subject = subject;

    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", subject='" + subject + '\'' +
                ", grade=" + grade +
                ", isRegistered='" + isRegistered + '\'' +
                '}';
    }
}
