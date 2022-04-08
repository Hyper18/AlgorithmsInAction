package Y2021B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class F {
	public static void main(String[] args) throws IOException {
		Calendar pre = Calendar.getInstance();
		pre.set(1970, 1, 1, 0, 0, 0);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		long curMillisTime = Long.parseLong(in.readLine());
		int secs = (int) (curMillisTime / 1000);
		pre.add(Calendar.SECOND, secs);

		int h = pre.get(Calendar.HOUR_OF_DAY);
		int m = pre.get(Calendar.MINUTE);
		int s = pre.get(Calendar.SECOND);
		StringBuilder sb = new StringBuilder();
		if (h < 10) {
			sb.append("0");
		}
		sb.append(h).append(":");
		if (m < 10) {
			sb.append("0");
		}
		sb.append(m).append(":");
		if (s < 10) {
			sb.append("0");
		}
		sb.append(s);

		System.out.println(sb.toString());
	}
}
