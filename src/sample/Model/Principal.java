package sample.Model;

public class Principal extends User {

    private String department;

    public Principal(String firstName, String lastName, String ssn, String email1, String password, int accessID, String department) {
        super(firstName, lastName, ssn, email1, password, accessID);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Principal{" +
                "department='" + department + '\'' +
                '}';
    }
}
