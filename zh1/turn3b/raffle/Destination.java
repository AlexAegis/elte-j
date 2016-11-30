package raffle;

import java.util.Arrays;
import java.lang.Character;

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

	public static Destination make(String city, String date, int price) {
		if(city.length() >= 2
			&& city.chars().allMatch(c -> Character.isLetter(c) || c == ' ')
			&& validDate(date)
			&& price > 0
			&& price <= MAX_PRICE) {
			return new Destination(city, date, price);
		} else {
			return null;
		}
	}

	public int getPrice() {
		return price;
	}

	public Destination betterHit(Destination d) {
		return d != null && price > d.getPrice() ? this : d;
	}

	private static boolean validDate(String date) {
		String[] data = date.trim().split("/");
		return data.length == 3 
					&& data[0].chars().allMatch(Character::isDigit)
					&& data[1].chars().allMatch(Character::isDigit)
					&& data[2].chars().allMatch(Character::isDigit)
					&& data[0].equals("2017")
					&& Integer.parseInt(data[1]) <= 12
					&& Integer.parseInt(data[1]) >= 1
					&& ((((data[1].equals("01") || data[1].equals("03") || data[1].equals("05") || data[1].equals("07") || data[1].equals("08") || data[1].equals("10") || data[1].equals("12")) && data[2].equals("31")))
						|| ((data[1].equals("02")) && Integer.parseInt(data[2]) <= 28)
						|| (((data[1].equals("04") || data[1].equals("06") || data[1].equals("09")) || data[1].equals("11")) && data[2].equals("30")));
	}

	@Override
	public String toString() {
		return city + " " + date + " (" + price + ")";
	}

}