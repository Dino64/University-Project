package sample.Model;


public class Classroom extends src.sample.Model.Course {
    private src.sample.Model.Course course;
    private int NumberOfSeats;
    private int RoomNumber;
    private boolean isBooked;

    public Classroom(String numberOfSeats, String roomNumber, boolean isBooked) {
        NumberOfSeats = Integer.parseInt(numberOfSeats);
        RoomNumber = Integer.parseInt(roomNumber);
        this.isBooked = isBooked;
    }

    public String getNumberOfSeats() {
        return String.valueOf(NumberOfSeats);
    }

    public void setNumberOfSeats(int numberOfSeats) {
        NumberOfSeats = numberOfSeats;
    }

    public int getRoomNumber() {
        return Integer.parseInt(String.valueOf(RoomNumber));
    }

    public void setRoomNumber(int roomNumber) {
        RoomNumber = roomNumber;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
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

    Classroom classroom01 = new Classroom("20", "01", false);
    Classroom classroom02 = new Classroom("15", "02", false);
    Classroom classroom03 = new Classroom("25","03", false);
}

