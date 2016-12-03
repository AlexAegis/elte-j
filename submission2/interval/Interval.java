package interval;

import interval.time.Day;
import interval.time.Time;

public class Interval implements Comparable<Interval> {

	private Day day;
	private Time time;
	private int length;

	private Interval(Day day, Time time, int length) {
		this.day = day;
		this.time = time;
		this.length = length;
	}

	public static Interval make(Day day, int hour, int minute, int length) {
		Time time = Time.make(hour, minute);
		if(time == null || time.add(length) == null || length < 30 || length > 180) return null;
		else return new Interval(day, time, length);
	}

	public Day getDay() {
		return day;
	}

	public Time getStartTime() {
		return time;
	}

	public Time getEndTime() {
		return time.add(length);
	}

	public int getLength() {
		return length;
	}

	public boolean endsBefore(Interval interval) {
		return getEndTime().compareTo(interval.getEndTime()) <= 0;
	}

	//CHECK this should be negated according to the task. If so, check ClassRoom::book
	public boolean overLapsWith(Interval interval) {
		return getEndTime().compareTo(interval.getStartTime()) <= 0 ||
				getStartTime().compareTo(interval.getEndTime()) >= 0;
	}

	@Override
	public String toString() {
		return day + " " + time + " - " + time.add(length);
	}

	@Override
	public boolean equals(Object o) {
        if(this == o) return true;
        else if(o == null || getClass() != o.getClass()) return false;
        return ((Interval) o).getDay() == day
				&& ((Interval) o).getStartTime().equals(time)
				&& ((Interval) o).getLength() == length;
	}

	@Override
	public int hashCode() {
		return time.hashCode() * length + day.toString().hashCode();
	}

    @Override
    public int compareTo(Interval interval) { 
    	if(equals(interval)) return 0;
    	else if(getDay().ordinal() < interval.getDay().ordinal()
    			|| getDay() == interval.getDay() && getStartTime().compareTo(interval.getStartTime()) < 0
    			|| getDay() == interval.getDay()
					&& getStartTime().equals(interval.getStartTime())
					&& getLength() < interval.getLength()) return 1;
    	else return -1;
    }
}