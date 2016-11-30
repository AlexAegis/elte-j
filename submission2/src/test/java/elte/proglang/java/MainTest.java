package elte.proglang.java;

import elte.proglang.java.interval.time.Time;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class MainTest {

    @Test
    public void MainTest() {
        Time time = Time.make(9, 5);
        System.out.println(time.toString());
        System.out.println(time.add(50).toString());
        System.out.println(time.add(90).toString());
        System.out.println(time.add(190).toString());
        assertTrue(true);
    }
}