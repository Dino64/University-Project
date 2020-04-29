package src.sample.Model;

public class Principal extends User {

    private String department;

    public Principal(String firstName, String lastName, String email, String ssn, String email1, String password, String phoneNumber, String department) {
        super(firstName, lastName, email, ssn, email1, password, phoneNumber);
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
