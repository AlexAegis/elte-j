package elte.proglang.java;

import elte.proglang.java.interval.time.Time;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class MainTest {

    @Test
    public void MainTest() {
        assertTrue(true);
    }

    @Test
    public void TimeCompareTest() {
        ArrayList<Time> arrayList = new ArrayList<>();
        Time timec = Time.make(11, 6);
        Time timea = Time.make(9, 5);
        Time timeb = Time.make(11, 5);
        arrayList.add(timea);
        arrayList.add(timeb);
        arrayList.add(timec);
        arrayList.stream().sorted().forEach(System.out::println);
        assertTrue(true);
    }
}