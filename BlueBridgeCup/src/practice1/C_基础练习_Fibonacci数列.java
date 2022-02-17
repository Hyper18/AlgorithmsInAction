package practice1;

import java.io.BufferedInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Hyperspace
 * @date 2022/02/17
 */
public class C_基础练习_Fibonacci数列 {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		int n = in.nextInt();
		int pre = 1;
		int curr = 1;
		for (int i = 3; i <= n; i++) {
			int tmp = (pre + curr) % 10007;
			pre = curr;
			curr = tmp;
		}
		out.println(curr);

		in.close();
		out.close();
	}
}
