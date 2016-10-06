import utils.IntList;

public class Main {
    public static void main(String[] args) {
        IntList l = new IntList(new int[]{1,3});
        l.add(2,2);
        l.add(4);
        l.show();

        l.remove();
        l.show();


    }
}
