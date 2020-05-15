package sample.Model;


public class Student extends User {

    private int studentID;
    private String registeredCourse;

    public String getRegisteredCourse() {
        return registeredCourse;
    }

    public Student(String firstName, String lastName, String ssn, String email, String password, int accessID, int studentID, String registeredCourse) {
        super(firstName, lastName, ssn, email, password, accessID);
        this.studentID = studentID;
        this.registeredCourse = registeredCourse;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID='" + studentID + '\'' +
                '}';
    }
}
