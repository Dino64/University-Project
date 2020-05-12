package sample.Model;

public class Room implements Model {
    private int id;
    private String whiteboard;
    private String projector;
    private int numOfSeats;
    private String isBooked;
    private String hasSpeaker;

    public Room(int id, String whiteboard, String projector, int numOfSeats, String isBooked, String hasSpeaker) {
        this.id = id;
        this.whiteboard = whiteboard;
        this.projector = projector;
        this.numOfSeats = numOfSeats;
        this.isBooked = isBooked;
        this.hasSpeaker = hasSpeaker;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWhiteboard() {
        return whiteboard;
    }

    public void setWhiteboard(String whiteboard) {
        this.whiteboard = whiteboard;
    }

    public String getProjector() {
        return projector;
    }

    public void setProjector(String projector) {
        this.projector = projector;
    }

    public int getNumOfSeats() {
        return numOfSeats;
    }

    public void setNumOfSeats(int numOfSeats) {
        this.numOfSeats = numOfSeats;
    }

    public String getIsBooked() {
        return isBooked;
    }

    public void setIsBooked(String isBooked) {
        this.isBooked = isBooked;
    }

    public String getHasSpeaker() {
        return hasSpeaker;
    }

    public void setHasSpeaker(String hasSpeaker) {
        this.hasSpeaker = hasSpeaker;
    }

    @Override
    public boolean matches(String key) {
        return false;
    }
}
