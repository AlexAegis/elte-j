package elte.proglang.java.classroom;

public class SeminarRoom extends ClassRoom {

    public SeminarRoom(String name, int seats) {
        super(name, seats);
    }

    @Override
    public int numberOfSpots() {
        return seats;
    }

    @Override
    public boolean hasComputers() {
        return false;
    }

    @Override
    public String toString() {
        return "gyakorlati terem (" + name + ")" + super.toString();
    }
}
