package elte.proglang.java.interval.time;

public enum Day {

    MONDAY("hetfo"),
    TUESDAY("kedd"),
    WEDNESDAY("szerda"),
    THURSDAY("csutortok"),
    FRIDAY("pentek");

    private final String name;

    Day(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}