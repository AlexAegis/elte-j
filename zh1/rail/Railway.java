package rail;

import java.lang.NumberFormatException;

public class Railway {

	private String cityA;
	private String cityB;
	private int distance;

	public static final Railway KESZTHELY_BUDAPEST = new Railway("Keszthely", "Budapest", 190);

	public Railway(String cityA, String cityB, int distance) {
		this.cityA = cityA;
		this.cityB = cityB;
		this.distance = distance;
	}

	public static Railway make(String entry) {
		String[] data = entry.trim().split(" ");
		if(data.length == 3) {
			try {
				int dist = Integer.parseInt(data[2]);
				return new Railway(data[0], data[1], dist);
			} catch(NumberFormatException e) {
				return null;
			}
		} else {
			return null;
		}		
	}

	public String[] getCities() {
		return new String[]{new String(cityA), new String(cityB)};
	}

	public int getDistance() {
		return distance;
	}

	public boolean hasEnd(String city) {
		return city.equals(cityA) || city.equals(cityB);
	}

	public String getOtherCity(String city) {
		if(hasEnd(city)) {
			return city.equals(cityA) ? cityB : cityA;
		} else {
			return null;
		}
	}

	@Override
	public String toString() {
		return "Railway(" + cityA + " - " + cityB + " " + distance + ")";
	}

}