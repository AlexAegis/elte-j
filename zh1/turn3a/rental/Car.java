package rental;

public class Car {

	private String brand;
	private String licensePlate;
	private double price;

	private static final double MAX_PRICE = 500.0;
	private static final Car CAR_OF_THE_YEAR = make("Alfa Romeo", "ABC 123", MAX_PRICE);

	private Car(String brand, String licensePlate, double price) {
		this.brand = brand;
		this.licensePlate = licensePlate;
		this.price = price;
	}

	public static Car make(String brand, String licensePlate, double price) {
		if(brand.length() >= 2
			&& brand.chars().allMatch(c -> Character.isLetter(c) || c == ' ')
			&& validLicensePlate(licensePlate)
			&& price > 0
			&& price <= MAX_PRICE) {
			return new Car(brand, licensePlate, price);
		} else {
			return null;
		}
	}

	private static boolean validLicensePlate(String licensePlate) {
		String[] plate = licensePlate.trim().split(" ");
		return licensePlate.length() == 7
					&& plate.length == 2
					&& plate[0].chars().allMatch(Character::isUpperCase) 
					&& plate[1].chars().allMatch(Character::isDigit);
	}

	public double getPrice() {
		return price;
	}

	public void decreasePrice() {
		if(price > 10 && price != MAX_PRICE) price -= 10;
	}

	public boolean cheaperThan(Car car) {
		return price < car.price;
	}

	@Override
	public String toString() {
		String p = Double.toString(price).replace(".", ",");
		if(price < 10) p = " " + p;
		if(price < 100) p = " " + p;
		return brand + " (" + licensePlate + ") " + p + " EUR";
	}
}