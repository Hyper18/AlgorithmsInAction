package Y2020B1;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author Hyperspace
 * @date 2022/04/07
 */
public class G八次求和 {
	private static final long MOD = 123456789;

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		int n = in.nextInt();
		long sum = 0;
		for (long i = 1; i <= n; i++) {
			long num = i % MOD;
			for (int j = 0; j < 8 - 1; j++) {
				num = (num * i) % MOD;
			}
			sum = (sum + num) % MOD;
		}

		System.out.println(sum);

		in.close();
	}
}
