package main;

import biblio.Bibliography;
import biblio.Entry;
import biblio.Query;
import csv.CSV;
import person.Author;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	private static final String PARAM_PUBLISHER = "publisher=";
	private static final String PARAM_AUTHOR = "author=";
	private static final String PARAM_FORMAT = "format=";

	public static void main(String[] args) {
		List<String> params = Arrays.asList(args);
		Bibliography bibliography = new Bibliography(CSV.read(new Scanner(System.in)));

		int format = 0;

		if ((params.contains(PARAM_AUTHOR) && params.size() > params.lastIndexOf(PARAM_AUTHOR) + 1)
			|| (params.contains(PARAM_PUBLISHER) && (params.size() > (params.lastIndexOf(PARAM_PUBLISHER) + 1)))) {
			if(params.lastIndexOf(PARAM_AUTHOR) > params.lastIndexOf(PARAM_PUBLISHER)) {
				bibliography.filter(Query.byAuthor(Author.make(params.get(params.lastIndexOf(PARAM_AUTHOR) + 1))));
			} else {
				bibliography.filter(Query.byPublisher(params.get(params.lastIndexOf(PARAM_PUBLISHER) + 1)));
			}
		}

		if (params.contains(PARAM_FORMAT) && params.size() > params.lastIndexOf(PARAM_FORMAT) + 1) {
			switch (params.get(params.lastIndexOf(PARAM_FORMAT) + 1)) {
				case "raw" : format = Entry.FORMAT_RAW;
					break;
				case "authorYear" : format = Entry.FORMAT_AUTHOR_YEAR;
					break;
				case "authorYearCompact" : format = Entry.FORMAT_AUTHOR_YEAR_COMPACT;
					break;
				default: break;
			}
		}
		System.out.print(bibliography.show(format));
	}
}