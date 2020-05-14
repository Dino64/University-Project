package sample.Model;


public class Classroom extends Course {
    private Course course;
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

    //Classroom classroom1 = new Classroom(20, 001, false);
    //Classroom classroom2 = new Classroom(30, 002, false);
    //Classroom classroom3 = new Classroom(40,003, true);
}

