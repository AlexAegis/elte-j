class Strategies {
    public static void main(String[] args) {
        Context context;
        int x, y;

        x = Integer.parseInt(args[0]);
        y = Integer.parseInt(args[1]);
        context = new Context(new Add());
        System.out.println("Add: " + context.compute(x, y));

        context = new Context(new Subtract());
        System.out.println("Subtract: " + context.compute(x, y));

        context = new Context(new Multiply());
        System.out.println("Multiply: " + context.compute(x, y));
    }
}