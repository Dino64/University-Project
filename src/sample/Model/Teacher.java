package sample.Model;

public class Teacher extends User {

    private String subject;

    public Teacher(String firstName, String lastName, String ssn, String email, String password, int accessID, String subject) {
        super(firstName, lastName, ssn, email, password, accessID);
        this.subject = subject;
    }


    @Override
    public String toString() {
        return "Teacher{" +
                "subject='" + subject + '\'' +
                '}';
    }
}
