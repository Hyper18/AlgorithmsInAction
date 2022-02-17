package practice1;

import java.io.BufferedInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Hyperspace
 * @date 2022/02/17
 * 贪心
 */
public class J_算法训练_最大最小公倍数 {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		long n = in.nextLong();
		if (n < 3) {
			out.println(n);
		} else {
			if (n % 2 == 1) {
				out.print(n * (n - 1) * (n - 2));
			} else {
				if (n % 3 != 0) {
					out.print(n * (n - 1) * (n - 3));
				} else {
					out.print((n - 1) * (n - 2) * (n - 3));
				}
			}
		}

		in.close();
		out.close();
	}
}
