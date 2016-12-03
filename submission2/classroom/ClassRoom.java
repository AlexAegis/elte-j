package classroom;

import interval.Interval;

import java.util.TreeMap;
import java.util.stream.Collectors;

public abstract class ClassRoom {

	protected String name;
	protected int seats;
	protected TreeMap<Interval, String> reservations = new TreeMap<>();

	public ClassRoom(String name, int seats) {
		this.name = name;
		this.seats = seats;
	}

	public String getName() {
		return name;
	}

	public abstract int numberOfSpots();

	public abstract boolean hasComputers();

	public boolean book(Interval interval, String name) {
		if(reservations.keySet().stream().allMatch(i -> i.overLapsWith(interval))) {
			reservations.put(interval, name);
			return true;
		} else return false;
	}

	@Override
	public String toString() {
        return "[" + reservations.entrySet().stream()
                .map(e -> e.getKey().toString() + " (" + e.getValue() + ")")
                .collect(Collectors.joining(", ")) + "]";
	}
}