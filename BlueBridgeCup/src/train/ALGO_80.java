package train;

import java.io.BufferedInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Hyper
 * @date 2022/03/02
 */
public class ALGO_80 {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		int n = in.nextInt();
		int[] nums = new int[n];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			nums[i] = in.nextInt();
			sum += nums[i];
		}

		out.println(sum / n);

		in.close();
		out.close();
	}
}
