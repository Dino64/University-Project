package sample.Model;


public class Classroom {

    private int NumberOfSeats;
    private int RoomNumber;
    private boolean isBooked;

    public Classroom(int numberOfSeats, int roomNumber, boolean isBooked) {
        NumberOfSeats = numberOfSeats;
        RoomNumber = roomNumber;
        this.isBooked = isBooked;
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

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }
}

