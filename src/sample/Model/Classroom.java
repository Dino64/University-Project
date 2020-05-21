package sample.Model;


public class Classroom extends Course {
    private Course course;
    private int NumberOfSeats;
    private int RoomNumber;
    private String isBooked;

    public Classroom(String numberOfSeats, String roomNumber, String isBooked) {
        NumberOfSeats = Integer.parseInt(numberOfSeats);
        RoomNumber = Integer.parseInt(roomNumber);
        this.isBooked = isBooked;
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

    public String getIsBooked() {
        return isBooked;
    }

    public void setIsBooked(String isBooked) {
        this.isBooked = isBooked;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "course=" + course +
                ", NumberOfSeats=" + NumberOfSeats +
                ", RoomNumber=" + RoomNumber +
                ", isBooked=" + isBooked +
                ", classroom01=" + classroom01 +
                ", classroom02=" + classroom02 +
                ", classroom03=" + classroom03 +
                '}';
    }

    Classroom classroom01 = new Classroom("20", "01", "false");
    Classroom classroom02 = new Classroom("15", "02", "false");
    Classroom classroom03 = new Classroom("25","03", "false");
}

