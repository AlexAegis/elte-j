package elte.proglang.java.interval.time;

public class Time implements Comparable<Time> {

    private int hour;
    private int minute;

    private Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public static Time make(int hour, int minute) {
        if(hour < 8 || hour > 18 || minute < 0 || minute > 59) return null;
        else return new Time(hour, minute);
    }

    public Time add(int minutes) {
        if(minutes < 0) return null;
        else return make(hour + minutes / 60, minute + minutes % 60);
    }

    @Override
    public String toString() { // String.format("%02d", minute);
        if(minute < 10) return hour + ":0" + minute;
        else return hour + ":" + minute;
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
    public int compareTo(Time o) { //check if this works (comparable interface now got a type)
        //if(o == null || getClass() != o.getClass()) return 0;
        if(((Time) o).hour > hour || ((Time) o).hour == hour && ((Time) o).minute > minute) return -1;
        else if(((Time) o).hour < hour || ((Time) o).hour == hour && ((Time) o).minute < minute) return 1;
        else return 0;
    }
}