package sample.Model;


public class Student extends User {

    private String studentID;
    private String registeredCourse;

    public String getRegisteredCourse() {
        return registeredCourse;
    }

    public Student(String firstName, String lastName, String ssn, String email1, String password, String phoneNumber, String studentID, String registeredCourse) {
        super(firstName, lastName, ssn, email1, password, phoneNumber);
        this.studentID = studentID;
        this.registeredCourse = registeredCourse;
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
