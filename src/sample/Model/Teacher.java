package sample.Model;

public class Teacher extends User {

    private String subject;

    public Teacher(String firstName, String lastName, String ssn, String email1, String password, int accessID, String subject) {
        super(firstName, lastName, ssn, email1, password, accessID);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "subject='" + subject + '\'' +
                '}';
    }
}
