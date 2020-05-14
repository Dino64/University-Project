package sample.Model;


public class Classroom {

    private int NumberOfSeats;
    private int RoomNumber;

    public Classroom(int numberOfSeats, int roomNumber) {
        NumberOfSeats = numberOfSeats;
        RoomNumber = roomNumber;
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
}