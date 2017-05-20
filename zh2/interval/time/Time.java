package interval.time;

public class Time implements Comparable<Time> {

    private int hour;
    private int minute;

    private Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public static Time make(int hour, int minute) {
        if((hour < 8 || hour >= 18 || minute < 0 || minute >= 60) && (hour != 18 || minute != 0)) return null;
        else return new Time(hour, minute);
    }

    public Time add(int minutes) {
        if(minutes < 0) return null;
        else return make((((hour * 60) + minute + minutes) / 60) % 24, ((hour * 60) + minute + minutes) % 60);
    }

    @Override
    public String toString() {
        return hour + String.format(":%02d", minute);
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        else if(o == null || getClass() != o.getClass()) return false;
        return hour == ((Time) o).hour && minute == ((Time) o).minute;
    }

    @Override
    public int hashCode() {
        return hour * minute + hour + minute;
    }

    @Override
    public int compareTo(Time time) {
        if(equals(time)) return 0;
        else if(time.hour < hour || time.hour == hour && time.minute < minute) return 1;
        else return -1;
    }
}