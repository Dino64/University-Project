package sample.Model;

public  class User implements Model  {

    private String firstName;
    private String lastName;
    private String ssn;
    private String email;
    private String password;
    private int accesID;

    public User(String firstName, String lastName, String ssn, String email, String password, int accesID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.email = email;
        this.password = password;
        this.accesID = accesID;
    }public User(String firstName,String lastName,String ssn,String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.email = email;
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

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", ssn='" + ssn + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", accesID=" + accesID +
                '}';
    }

    public int getAccesID() {
        return accesID;
    }

    public void setAccesID(int accesID) {
        this.accesID = accesID;
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

        } else return String.format("%s %s", firstName, lastName).matches(".*" + key + ".*") || String.format("%s %s", firstName, lastName).toLowerCase().matches(".*" + key + ".*");
    }
}


