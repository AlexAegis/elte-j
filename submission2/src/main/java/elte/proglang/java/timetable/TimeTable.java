package elte.proglang.java.timetable;

import elte.proglang.java.classroom.ClassRoom;
import elte.proglang.java.interval.Interval;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TimeTable {

    private List<ClassRoom> classRooms = new ArrayList<>();

    public void add(ClassRoom classRoom) {
        if(classRooms.stream().anyMatch(c -> c.getName().equals(classRoom.getName())))
            throw new IllegalArgumentException("multiple names: " + classRoom.getName());
        else classRooms.add(classRoom);
    }

    private static boolean accept(ClassRoom classRoom, int requestedSeats, boolean needsComputers) {
        return needsComputers == classRoom.hasComputers() && classRoom.numberOfSpots() >= requestedSeats;
    }

    public void book(String name, Interval interval, int requestedSeats, boolean needsComputers) throws BookingException {
        boolean notFoundRoom = true;
        boolean noSuitableRoom = true;
        for(ClassRoom cl : classRooms.stream().filter(classRoom -> accept(classRoom, requestedSeats, needsComputers)).collect(Collectors.toList())) {
            noSuitableRoom = false;
            if(cl.book(interval, name)) {
                notFoundRoom = false;
                break;
            }
        }
        if(noSuitableRoom) throw new BookingException("There is no room of the specified type available in the given interval.");
        if(notFoundRoom) throw new BookingException("No room available in the given interval.");
    }

    @Override
    public String toString() {
        return classRooms.stream().map(ClassRoom::toString).collect(Collectors.joining("\n")) + "\n";
    }
}