package src.sample.Model;

public class Teacher extends User {
    private String subject;

    public Teacher(String firstName, String lastName, String email, String ssn, String email1, String password, String phoneNumber, String subject) {
        super(firstName, lastName, email, ssn, email1, password, phoneNumber);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }


}
