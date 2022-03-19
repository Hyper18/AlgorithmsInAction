package practice.practice1;

import java.io.BufferedInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Hyperspace
 * @date 2022/02/17
 */
public class I_算法训练_区间k大数查询 {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		int n = in.nextInt();
		in.nextLine();
		String[] array = in.nextLine().split(" ");
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(array[i]);
		}
		int m = in.nextInt();
		in.nextLine();
		for (int i = 0; i < m; i++) {
			String[] s = in.nextLine().split(" ");
			int l = Integer.parseInt(s[0]);
			int r = Integer.parseInt(s[1]);
			int k = Integer.parseInt(s[2]);

			int[] window = Arrays.copyOfRange(arr, l - 1, r);
			Arrays.sort(window);

			int len = window.length;
			out.println(window[len - k]);
		}

		in.close();
		out.close();
	}
}
