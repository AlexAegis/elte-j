import java.util.Set;
import java.util.HashSet;

public class TimeDuplicates {

	public static void main(String[] args) {
		Time t1 = new Time(0, 0, 0);
		Time t2 = new Time(11, 05, 43);
		Time t3 = new Time(23, 59, 59);
		Time t4 = new Time(8, 55, 2);
		Time t5 = new Time(11, 05, 43);

		Set<Time> timeSet = new HashSet<>();
		timeSet.add(t1);
		timeSet.add(t2);
		timeSet.add(t3);
		timeSet.add(t4);
		timeSet.add(t5);

		for(Time time : timeSet) {
			System.out.println(time.toString());
		}

	}
}