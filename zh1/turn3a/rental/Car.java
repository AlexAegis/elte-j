package rental;

public class Car {

	private String brand;
	private String licencePlate;
	private double price;

	private static double MAX_PRICE = 500.0;
	private static Car CAR_OF_THE_YEAR = new Car("Alfa Romeo", "ABC 123", 500.0);

	private Car(String brand, String licencePlate, double price) {
		this.brand = brand;
		this.licencePlate = licencePlate;
		this.price = price;
	}

	public static Car make(String brand, String licencePlate, double price) {
		if(brand.length() >= 2
			&& brand.chars().allMatch(c -> Character.isLetter(c) || c == ' ')
			&& validLicensePlate(licencePlate)
			&& price > 0
			&& price <= MAX_PRICE) {
			return new Car(brand, licencePlate, price);
		} else {
			return null;
		}
	}

	private static boolean validLicensePlate(String licencePlate) {
		String[] plate = licencePlate.trim().split(" ");
		return plate.length == 2
					&& plate[0].length() == 3 && plate[1].length() == 3
					&& plate[0].chars().allMatch(c -> Character.isLetter(c) && Character.isUpperCase(c)) 
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
	public String toString() { // TODO format price
		String p = Double.toString(price).replace(".", ",");
		if(price < 10) p = " " + p;
		if(price < 100) p = " " + p;
		return brand + " (" + licencePlate + ") " + p + " EUR";
	}
}