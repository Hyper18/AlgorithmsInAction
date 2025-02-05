package practice.practice1;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * @author Hyper
 * @date 2022/02/17
 */
public class E_基础练习_01字串 {
	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < Math.pow(2, 5); i++) {
			String s = Integer.toBinaryString(i);
			int res = Integer.parseInt(s);
			out.printf("%05d", res);
			out.println();
		}
		out.close();
	}
}
