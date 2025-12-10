package src.main.java;

/**
 * Represents a year, day, and optional challenge part
 */
public class AdventDate {
    private final int year;
    private final String day;
    private int part;

    public AdventDate(int year, String day) {
        this.year = year;
        this.day = day;
    }

    public void setPart(int part) {
        this.part = part;
    }

    public int year() {
        return year;
    }

    public String day() {
        return day;
    }

    public int part() {
        return part;
    }

}