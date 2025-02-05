package Y2020B1;

import java.util.Calendar;

/**
 * @author Hyper
 * @date 2022/04/07
 */
public class B纪念日 {
	public static void main(String[] args) {
		Calendar pre = Calendar.getInstance();
		Calendar now = Calendar.getInstance();
		pre.set(1921, 7 - 1, 23);
		now.set(2020, 7 - 1, 1);

		System.out.println((now.getTimeInMillis() - pre.getTimeInMillis()) / 1000 / 60);
	}
}
