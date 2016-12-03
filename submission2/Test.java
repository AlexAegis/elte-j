import interval.Interval;
import interval.time.Day;

import static org.junit.Assert.assertTrue;

public class Test {

    @org.junit.Test
    public void randomTest() {
        assertTrue(!Interval.make(Day.MONDAY,9,0,30).overlapsWith(Interval.make(Day.FRIDAY,12,30,120)));
    }

    @org.junit.Test
    public void randomTest2() {
        assertTrue(!Interval.make(Day.MONDAY,12,30,30).overlapsWith(Interval.make(Day.FRIDAY,9,0,120)));
    }

    @org.junit.Test
    public void randomTest3() {
        assertTrue(!Interval.make(Day.MONDAY,12,30,120).overlapsWith(Interval.make(Day.FRIDAY,9,0,30)));
    }

    @org.junit.Test
    public void randomTest4() {
        assertTrue(!Interval.make(Day.MONDAY,12,30,60).overlapsWith(Interval.make(Day.FRIDAY,13,0,60)));
    }

    @org.junit.Test
    public void randomTest5() {
        assertTrue(!Interval.make(Day.TUESDAY,9,0,60).overlapsWith(Interval.make(Day.TUESDAY,12,0,60)));
    }

    @org.junit.Test
    public void randomTest6() {
        assertTrue(!Interval.make(Day.TUESDAY,9,0,60).overlapsWith(Interval.make(Day.TUESDAY,10,0,60)));
    }

    @org.junit.Test
    public void randomTest7() {
        assertTrue(!Interval.make(Day.TUESDAY,10,0,60).overlapsWith(Interval.make(Day.TUESDAY,9,0,60)));
    }

    @org.junit.Test
    public void randomTest8() {
        assertTrue(!Interval.make(Day.TUESDAY,12,0,60).overlapsWith(Interval.make(Day.TUESDAY,9,0,60)));
    }

    @org.junit.Test
    public void randomTest9() {
        assertTrue(!Interval.make(Day.FRIDAY,12,30,120).overlapsWith(Interval.make(Day.MONDAY,9,0,30)));
    }

    @org.junit.Test
    public void randomTest10() {
        assertTrue(!Interval.make(Day.FRIDAY,9,0,120).overlapsWith(Interval.make(Day.MONDAY,12,30,30)));
    }

    @org.junit.Test
    public void randomTest11() {
        assertTrue(!Interval.make(Day.FRIDAY,9,0,30).overlapsWith(Interval.make(Day.MONDAY,12,30,120)));
    }

    @org.junit.Test
    public void randomTest12() {
        assertTrue(!Interval.make(Day.FRIDAY,13,0,60).overlapsWith(Interval.make(Day.MONDAY,12,30,60)));
    }

    @org.junit.Test
    public void randomTest13() {
        assertTrue(Interval.make(Day.WEDNESDAY,9,0,60).overlapsWith(Interval.make(Day.WEDNESDAY,9,30,60)));
    }

    @org.junit.Test
    public void randomTest14() {
        assertTrue(Interval.make(Day.WEDNESDAY,9,0,120).overlapsWith(Interval.make(Day.WEDNESDAY,9,30,30)));
    }

    @org.junit.Test
    public void randomTest15() {
        assertTrue(Interval.make(Day.WEDNESDAY,9,30,30).overlapsWith(Interval.make(Day.WEDNESDAY,9,0,120)));
    }

    @org.junit.Test
    public void randomTest16() {
        assertTrue(Interval.make(Day.WEDNESDAY,9,30,60).overlapsWith(Interval.make(Day.WEDNESDAY,9,0,60)));
    }
}