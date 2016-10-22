package person;

import java.util.Arrays;
import java.util.List;

public class Author {

	private String firstName;
	private String lastName;

	private Author(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Author(Author author) {
		this(author.getFirstName(), author.getLastName());
	}

	public static Author make(String names) {
		String name = names.trim();
		List<String> nameAsList = Arrays.asList(name.split(" "));
		if(names.isEmpty() 
			|| !name.contains(" ") 
			|| nameAsList.size() != 2
			|| nameAsList.get(0).length() < 1 
			|| nameAsList.get(1).length() < 1
			|| Character.isLowerCase(nameAsList.get(0).charAt(0))
			|| Character.isLowerCase(nameAsList.get(1).charAt(0))) {
			return null;
		} else {
			return new Author(nameAsList.get(0), nameAsList.get(1));
		}
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String show() {
		return getLastName() + ", " + getFirstName().charAt(0);
	}

	public boolean equals(Author author) {
		return author != null
				&& author.getLastName().equals(getLastName())
				&& author.getFirstName().equals(getFirstName());
	}
}