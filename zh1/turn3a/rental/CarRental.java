package rental;

import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Random;

public class CarRental {

	private List<Car> cars = new ArrayList<>();

	public CarRental(String fileName) {
		try(Scanner scn = new Scanner(new File(fileName))) {
			while(scn.hasNextLine()) {
				String data = scn.nextLine();
				String[] details = data.replace(":", ",").split(",");
				if(data.contains(":") && data.contains(",") && details.length == 3) {
					try {
						double price = Double.parseDouble(details[2]);
						Car car = Car.make(details[0], details[1], price);
						if(car != null) cars.add(car);
					} catch (NumberFormatException e) { /* e.printStackTrace(); */ }
				}
			}
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
		}
	}

	public Car rentCheapest() {
		if(!cars.isEmpty()) {
			insertionSort();
			Car car = cars.get(0);
			cars.remove(car);
			return car;
		} else {
			return null;
		}
	}

	public ArrayList<Car> sale() {
		return new ArrayList<>(cars.stream().map(c -> { 
			if(new Random().nextBoolean()) c.decreasePrice();
			return c;
		}).collect(Collectors.toList()));
	}

	public ArrayList<Car> simulate() {
		ArrayList<Car> result = new ArrayList<>();
		while(!cars.isEmpty()) {
			cars = sale();
			result.add(rentCheapest());
		}
		return result;
	}

	public void insertionSort() {
		cars = cars.stream().sorted((a, b) -> {
			if(a.getPrice() > b.getPrice()) return 1;
			else if(a.getPrice() < b.getPrice()) return -1;
			else return 0;
		}).collect(Collectors.toList());
	}

	public double weightedAverage() {
		if(!cars.isEmpty()) return cars.stream().mapToDouble(car -> car.getPrice() * (cars.indexOf(car) + 1)).sum() /
				cars.stream().mapToDouble(car -> cars.indexOf(car) + 1).sum();
		return -1;
	}

	public int numberOfCars() {
		return cars.size();
	}

	@Override
	public String toString() {
		String result = "";
		for(int i = 0; i < numberOfCars(); i++) {
			result += cars.get(i).toString();
			if(i != numberOfCars() - 1) result += "\n";
		}
		return result;
	}

}