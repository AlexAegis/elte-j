import java.io.*;
import java.util.Scanner;

class Heat {

    private Heat() {

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int value = scn.nextInt(); scn.nextLine();
        String type = scn.nextLine();
        try {
            System.out.println(new HeatConverter(value).setHeatType(type).getAsOther());
        } catch (WrongHeatTypeException e) {
            System.out.println("Bad heat type");
            e.printStackTrace();
        }
    }
}
