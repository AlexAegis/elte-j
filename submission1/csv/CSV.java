package csv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CSV {

    private String[][] strings;

    private CSV(String[][] strings) {
        this.strings = strings;
    }

    public static CSV read(Scanner scanner) {

        //Reading as a List of Lists
        List<List<String>> result = new ArrayList<>();
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            List<String> lineAsList = Arrays.asList(line.split(","));
            List<String> trimmedLine = new ArrayList<>();
            lineAsList.forEach(s -> trimmedLine.add(s.trim()));
            result.add(trimmedLine);
        }

        //Initialize a number of lines long array of string arrays
        String[][] resultAsArray = new String[result.size()][];

        //Create the lines as arrays then add them to the result array
        int n = 0;
        for(List<String> line : result) {
            String[] lineAsArray = new String[line.size()];
            lineAsArray = line.toArray(lineAsArray);
            resultAsArray[n] = lineAsArray;
            n++;
        }

        return new CSV(resultAsArray);

    }

    public String[][] getContents() {
            String[][] result = this.strings.clone();
            for (int i = 0; i < this.strings.length; i++) {
                result[i] = this.strings[i].clone();
            }
            return result;
    }

}