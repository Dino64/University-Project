package src.sample.Model;

abstract class User {
    private String firstName;
    private String lastName;
    private String email;
    private String ssn;
    private String Email;
    private String Password;
    private String phoneNumber;

    public User(String firstName, String lastName, String email, String ssn, String email1, String password, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.ssn = ssn;
        Email = email1;
        Password = password;
        this.phoneNumber = phoneNumber;
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

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", ssn='" + ssn + '\'' +
                ", Email='" + Email + '\'' +
                ", Password='" + Password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
