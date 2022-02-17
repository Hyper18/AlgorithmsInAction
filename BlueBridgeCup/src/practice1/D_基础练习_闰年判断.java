package practice1;

import java.io.BufferedInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Hyperspace
 * @date 2022/02/17
 */
public class D_基础练习_闰年判断 {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		int y = in.nextInt();
		boolean flag = false;

		if (y % 400 == 0 || (y % 4 == 0 && y % 100 != 0)) {
			flag = true;
		}

		if (flag) {
			out.println("yes");
		} else {
			out.println("no");
		}

		in.close();
		out.close();
	}
}
