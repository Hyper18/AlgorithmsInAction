package practice1;

import java.io.BufferedInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Hyperspace
 * @date 2022/02/17
 */
public class H_基础练习_查找整数 {
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
		int target = in.nextInt();

		boolean flag = true;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == target) {
				flag = false;
				out.println(i + 1);
				break;
			}
		}

		if (flag) {
			out.println(-1);
		}

		in.close();
		out.close();
	}
}
