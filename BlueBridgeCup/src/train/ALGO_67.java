package train;

import java.io.BufferedInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Hyperspace
 * @date 2022/03/01
 */
public class ALGO_67 {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		int[] nums = new int[11];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = in.nextInt();
		}

		int min = Arrays.stream(nums).min().getAsInt();
		int max = Arrays.stream(nums).max().getAsInt();

		out.print(max + " " + min);

		in.close();
		out.close();
	}

}
