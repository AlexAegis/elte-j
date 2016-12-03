package classroom;

public class ComputerLab extends ClassRoom {

    private int computers;

    public ComputerLab(String name, int seats, int computers) {
        super(name, seats);
        this.computers = computers;
    }

    @Override
    public int numberOfSpots() {
        return (int) Math.max(seats, computers * 1.1);
    }

    @Override
    public boolean hasComputers() {
        return computers > 0;
    }

    @Override
    public String toString() {
        return "gepterem (" + name + ") " + super.toString();
    }
}