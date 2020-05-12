package sample.Model;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public class Booking implements Model {

    private Time startTime;
    private Time endTime;
    private Date startDate;
    private Date endDate;
    private int Id;
    private String member;

    private List<Room> Rooms;


    public Booking() {

    }

    public Booking(Time startTime, Time endTime, Date startDate, Date endDate, int id, String member, List<Room> rooms) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.startDate = startDate;
        this.endDate = endDate;
        Id = id;
        this.member = member;
        Rooms = rooms;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public List<Room> getRooms() {
        return Rooms;
    }

    public void setRooms(List<Room> rooms) {
        Rooms = rooms;
    }

    @Override
    public boolean matches(String key) {
        if (Integer.toString(Id).equals(key)) {
            return true;
        } else if (member.matches(".*" + key + ".*")) {
            return true;
        } else {
            return false;
        }
    }
}
