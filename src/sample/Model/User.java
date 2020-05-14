package sample.Model;

public  abstract class User implements Model  {

    private String firstName;
    private String lastName;
    private String ssn;
    private String email;
    private String password;
    private String phoneNumber;

    public User(String firstName, String lastName, String ssn, String email, String password, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.email = email;
        this.password = password;
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


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public boolean matches(String key) {
        if (ssn.matches(key)) {
            return true;
        } else if (firstName.matches(".*"+key+".*") || firstName.toLowerCase().matches(".*"+key+".*")) {
            return true;
        } else if (lastName.matches(".*"+key+".*") || lastName.toLowerCase().matches(".*"+key+".*")) {
            return true;
        } else if (email.matches(".*"+key+".*") || email.toLowerCase().matches(".*"+key+".*")) {
            return true;
        } else if (phoneNumber.matches(".*"+key+".*")) {
            return true;
        } else if (String.format("%s %s", firstName, lastName).matches(".*"+key+".*") || String.format("%s %s", firstName, lastName).toLowerCase().matches(".*"+key+".*")) {
            return true;
        } else {
            return false;
        }
    }
}


