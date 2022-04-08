package Y2021B;

import java.util.HashSet;
import java.util.Set;

public class D2 {
	private static final long num = 2021041820210418L;

	public static void main(String[] args) {
		Set<Long> set = new HashSet<>();
		for (long i = 1; i <= (long) Math.sqrt(num); i++) {
			if (num % i == 0) {
				set.add(num / i);
				set.add(i);
			}
		}

		Long[] nums = set.toArray(new Long[0]);
		int ans = 0;
		for (long a : nums) {
			for (long b : nums) {
				for (long c : nums) {
					if (a * b * c == num) {
						ans++;
					}
				}
			}
		}

		System.out.println(ans);
	}
}
