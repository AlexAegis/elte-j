package biblio;

import csv.CSV;
import person.Author;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Bibliography {

	private List<Entry> entries;

	public Bibliography(CSV csv) {
		Entry.resetId();
		entries = new ArrayList<>();
		for (String[] line : csv.getContents()) {
			if (line.length == 4 
					&& line[3].matches("^-?\\d+$")
					&& Author.make(line[0]) != null) {
				entries.add(Entry.make(Author.make(line[0])
								, line[1]
								, Integer.parseUnsignedInt(line[3])
								, line[2]));
			}
		}
	}

	public void filter(Query query) {
		entries = entries.stream().filter(query::accept).collect(Collectors.toList());
	}

	public String show(int format) {

		String result = "";
		for(Entry entry : entries) {
			if(entry != null) {
				result = result.concat(entry.show(format) + "\n");
			}
		}
		return result;
	}
}