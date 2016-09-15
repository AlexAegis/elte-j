class OneToHundred {

    private static String out;

    private OneToHundred() {

    }

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {

            if((i % 3 == 0) && !(i % 5 == 0)) {
                out = "Fizz";
            } else if(!(i % 3 == 0) && (i % 5 == 0)) {
                out = "Buzz";
            } else if((i % 3 == 0) && (i % 5 == 0)) {
                out = "FizzBuzz";
            } else {
                out = new Integer(i).toString();
            }
            System.out.println(out);
        }
    }
}
