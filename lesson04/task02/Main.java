import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        List<String> l = new ArrayList<>();
        for(;true; l.add(scn.nextLine())) {
            Collections.reverse(l);
            for (String s : l) {
                System.out.println("-" + s);
            }
            Collections.reverse(l);
        }
    }
}
