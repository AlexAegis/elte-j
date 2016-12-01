package elte.proglang.java.classroom;

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
		if(reservations.keySet().stream().anyMatch(Interval::overLapsWith)) return false;
		else {
			reservations.put(interval, name);
			return true;
		}
	}
	//  List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
 	// String commaSeparatedNumbers = numbers.stream()
    //  .map(i -> i.toString())
    //  .collect(Collectors.joining(", "));

    // Stream.of(keyset, valueset)

    // flatmap etc

	@Override
	public String toString() {
		return "[" + reservations.
	}
}
