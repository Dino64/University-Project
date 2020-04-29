package src.sample.Model;

public class Student extends User {

    private String StudentID;


    public Student(String firstName, String lastName, String email, String ssn, String email1, String password, String phoneNumber, String studentID) {
        super(firstName, lastName, email, ssn, email1, password, phoneNumber);
        StudentID = studentID;
    }

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    @Override
    public String toString() {
        return "Student{" +
                "StudentID='" + StudentID + '\'' +
                '}';
    }
}
