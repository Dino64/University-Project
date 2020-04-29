package src.sample.Model;

abstract class User {
    private String name;
    private String lastName;
    private String email;
    private String ssn;


    public User(String name, String lastName, String email, String ssn) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.ssn = ssn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", ssn='" + ssn + '\'' +
                '}';
    }
}
