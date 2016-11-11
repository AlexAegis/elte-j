package raffle;

public class Destination {

	private String city;
	private String date;
	private int price;

	private static final int MAX_PRICE = 7500;
	private static final Destination DESTINATION_OF_THE_YEAR = make("New York", "2017/12/31", MAX_PRICE);

	private Destination(String city, String date, int price) {
		this.city = city;
		this.date = date;
		this.price = price;
	}

	public static make(String city, String date, int price) {
		if(city.length() >= 2
			&& city.chars().allMatch(c -> Character.isLetter(c) || c == ' ')
			&& validDate(date)
			&& price > 0
			&& price <= MAX_PRICE) {
			return new Car(brand, licensePlate, price);
		} else {
			return null;
		}
	}


}