package sample.Model;

public class Teacher extends User {

    private String subject;
    private String grade;
    public Teacher(String firstName, String lastName, String ssn, String email, String password, int accessID, String subject, String grade) {
        super(firstName, lastName, ssn, email, password, accessID);
        this.subject = subject;
        this.grade = grade;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "subject='" + subject + '\'' +
                '}';
    }
}
