package sample.Model;

public class AddGrade {

    private int IdNr;
    private String firstName,lastName ,email,SSN,subject,grade;

    public AddGrade() {

        this.IdNr = IdNr;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.SSN = SSN;
        this.subject = subject;
        this.grade = grade;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public int getIdNr() {
        return IdNr;
    }

    public void setIdNr(int IdNr) {
        this.IdNr = IdNr;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "addGrade{" +
                "IdNr=" + IdNr +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", SSN='" + SSN + '\'' +
                ", subject='" + subject + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }

}
