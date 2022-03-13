package Y2013A;

import java.util.Calendar;

/**
 * @author Hyperspace
 * @date 2022/03/13
 * Calendar类的使用
 */
public class Q1世纪末的星期 {
	public static void main(String[] args) {
		for (int year = 1999; year < 10000; year += 100) {
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.YEAR, year);
			calendar.set(Calendar.MONTH, 12 - 1);
			calendar.set(Calendar.DATE, 31);
			if (calendar.get(Calendar.DAY_OF_WEEK) == 1) {
				System.out.println(calendar.get(Calendar.YEAR));
				break;
			}
		}
	}
}
