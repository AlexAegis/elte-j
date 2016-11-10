public class Time {

	public final int hour;
	public final int minute;
	public final int second;

	public Time(int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}

	@Override
	public boolean equals(Object o) {
		if(o == null || o.getClass() != this.getClass()) return false;
		Time time = (Time) o;
		return this.hour == time.hour && this.minute == time.minute && this.second == time.second; 
	}

	@Override
	public int hashCode() {
		return new Double(hour * 29 + minute * 30 + second * 31).hashCode();
	}

	@Override
	public String toString() {
		return "H: " + hour + " M: " + minute + " S: " + second;
	}

}