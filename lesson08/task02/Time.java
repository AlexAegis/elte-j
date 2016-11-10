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
	public String toString() {
		return "H: " + hour + " M: " + minute + " S: " + second;
	}

}