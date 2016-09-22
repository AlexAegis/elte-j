class Main {

    public static void main(String[] args) {
        Person a = new Person();
        Name n = new NameBuilder().addName("Tom").addName("Hanks").getName();
        System.out.println(n.toString());
    }

}
