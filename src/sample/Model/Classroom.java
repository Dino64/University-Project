package sample.Model;


import java.util.Date;

public class Classroom extends Course {
    private Course course;
    private int NumberOfSeats;
    private int RoomNumber;
    private boolean isBooked;
    private Date date;

    public Classroom(int numberOfSeats, int roomNumber, boolean isBooked, Date date) {
        NumberOfSeats = numberOfSeats;
        RoomNumber = roomNumber;
        this.isBooked = isBooked;

    }

    public Classroom() {

    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getNumberOfSeats() {
        return NumberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        NumberOfSeats = numberOfSeats;
    }

    public int getRoomNumber() {
        return RoomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        RoomNumber = roomNumber;
    }

    public boolean getIsBooked() {
        return isBooked;
    }

    public void setIsBooked(boolean isBooked) {
        this.isBooked = isBooked;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "course=" + course +
                ", NumberOfSeats=" + NumberOfSeats +
                ", RoomNumber=" + RoomNumber +
                ", isBooked=" + isBooked + "date" + date +
                /*", classroom01=" + classroom01 +
                ", classroom02=" + classroom02 +
                ", classroom03=" + classroom03 +*/
                '}';
    }

    /*Classroom classroom01 = new Classroom("20", "01", "false");
    Classroom classroom02 = new Classroom("15", "02", "false");
    Classroom classroom03 = new Classroom("25","03", "false");*/
}

