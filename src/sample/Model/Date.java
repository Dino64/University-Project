package sample.Model;

public class Date {
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private int second;

    public Date(int year, int month, int day, int hour, int minute, int second) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    @Override
    public String toString() {
        return "Date{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                ", hour=" + hour +
                ", minute=" + minute +
                ", second=" + second +
                '}';
    }
}
