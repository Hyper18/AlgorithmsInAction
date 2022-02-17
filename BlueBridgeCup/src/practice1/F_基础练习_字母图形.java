package practice1;

import java.io.BufferedInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Hyperspace
 * @date 2022/02/17
 */
public class F_基础练习_字母图形 {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		String[] ss = in.nextLine().split(" ");
		int n = Integer.parseInt(ss[0]);
		int m = Integer.parseInt(ss[1]);

		StringBuilder sb;
		for (int i = 0; i < n; i++) {
			sb = new StringBuilder();
			for (int j = 0; j < m; j++) {
				sb.append((char) ('A' + Math.abs(i - j)));
			}
			out.println(sb);
		}
		in.close();
		out.close();
	}
}
