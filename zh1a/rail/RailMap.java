package rail;

import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.LinkedList;
import java.io.File;
import java.io.IOException;

public class RailMap {
	
	private String country;
	private List<Railway> railways = new LinkedList<>();

	public RailMap(String country, String fileName) throws IOException {
		this.country = country;
		try(Scanner scn = new Scanner(new File(fileName))) {
			while(scn.hasNextLine()) {
				Railway railway = Railway.make(scn.nextLine());
				if(railway != null) {
					railways.add(railway);
				}
			}
		}
	}

	public List<String> getCities() {
		List<String> result = new LinkedList<>();
		railways.forEach(railway -> {
			Arrays.stream(railway.getCities()).forEach(city -> {
				if(!result.stream().anyMatch(str -> str.equals(city))) {
					result.add(city);
				}
			});
		});
		return result;
	}

	public List<String> getNeighbours(String city) {
		List<String> result = new LinkedList<>();
		railways.forEach(railway -> {
			if(railway.hasEnd(city)) {
				result.add(railway.getOtherCity(city));
			}
		});
		return result;
	}

	public String capitalCity() {
		return getCities().stream().max((a, b) -> {
			int aSize = getNeighbours(a).size();
			int bSize = getNeighbours(b).size();
			if(aSize > bSize) return 1;
			else if(aSize < bSize) return -1;
			else return 0;
		}).orElse(null);
	}

	@Override
	public String toString() {
		String result = "RailMap(" + country + ",[";
		railways.forEach(railway -> result.concat(railway.toString()));
		return result + "])";
	}

}