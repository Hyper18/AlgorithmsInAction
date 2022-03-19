package practice.practice1;

import java.io.BufferedInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Hyperspace
 * @date 2022/02/17
 */
public class G_基础练习_数列特征 {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		int n = in.nextInt();
		in.nextLine();
		String[] nums = in.nextLine().split(" ");

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int sum = 0;
		for (String num : nums) {
			int currNum = Integer.parseInt(num);
			if (currNum > max) {
				max = currNum;
			}
			if (currNum < min) {
				min = currNum;
			}
			sum += currNum;
		}

		out.println(max);
		out.println(min);
		out.println(sum);

		in.close();
		out.close();
	}
}
