package src.sample.Model;

public class Principal extends User {

    private String Department;

    public Principal(String firstName, String lastName, String email, String ssn, String email1, String password, String phoneNumber, String department) {
        super(firstName, lastName, email, ssn, email1, password, phoneNumber);
        Department = department;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    @Override
    public String toString() {
        return "Principal{" +
                "Department='" + Department + '\'' +
                '}';
    }
}
