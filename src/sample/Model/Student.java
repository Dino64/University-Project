package sample.Model;


public class Student extends User {

    private String studentID;

    public Student(String firstName, String lastName, String ssn, String email1, String password, String phoneNumber, String studentID) {
        super(firstName, lastName, ssn, email1, password, phoneNumber);
        this.studentID = studentID;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID='" + studentID + '\'' +
                '}';
    }
}
