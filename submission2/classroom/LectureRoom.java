package classroom;

public class LectureRoom extends ClassRoom {

    public LectureRoom(String name, int seats) {
        super(name, seats);
    }

    @Override
    public int numberOfSpots() {
        return (int) (seats * 0.9);
    }

    @Override
    public boolean hasComputers() {
        return false;
    }

    @Override
    public String toString() {
        return "eloadoterem (" + name + ")" + super.toString();
    }
}