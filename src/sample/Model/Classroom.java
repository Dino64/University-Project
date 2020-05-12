package sample.Model;

import sample.Model.*;

public class Classroom extends Room {

    private String isForSeminar;
    private String isForGroupWork;
    private String isForTeaching;

    public Classroom(int id, String whiteboard, String projector, int numOfSeats, String isBooked, String hasSpeaker, String isForSeminar, String isForGroupWork, String isForTeaching) {
        super(id, whiteboard, projector, numOfSeats, isBooked, hasSpeaker);
        this.isForSeminar = isForSeminar;
        this.isForGroupWork = isForGroupWork;
        this.isForTeaching = isForTeaching;
    }

    public String getIsForSeminar() {
        return isForSeminar;
    }

    public void setIsForSeminar(String isForSeminar) {
        this.isForSeminar = isForSeminar;
    }

    public String getIsForGroupWork() {
        return isForGroupWork;
    }

    public void setIsForGroupWork(String isForGroupWork) {
        this.isForGroupWork = isForGroupWork;
    }

    public String getIsForTeaching() {
        return isForTeaching;
    }

    public void setIsForTeaching(String isForTeaching) {
        this.isForTeaching = isForTeaching;
    }
}
