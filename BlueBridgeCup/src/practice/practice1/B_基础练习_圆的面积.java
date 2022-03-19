package practice.practice1;

import java.io.*;

/**
 * @author Hyperspace
 * @date 2022/02/17
 */
public class B_基础练习_圆的面积 {
	public static void main(String[] args) throws IOException {
		StreamTokenizer in = new StreamTokenizer(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		in.nextToken();
		int r = (int) in.nval;

		double s = Math.PI * r * r;
		out.printf("%.7f", s);

		out.close();
	}
}
