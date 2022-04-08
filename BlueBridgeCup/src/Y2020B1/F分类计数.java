package Y2020B1;

import java.io.*;

/**
 * @author Hyperspace
 * @date 2022/04/07
 */
public class F分类计数 {
	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

	public static void main(String[] args) throws IOException {
		String s = in.readLine();

		int higherCaseLetters = 0;
		int lowerCaseLetters = 0;
		int numbers = 0;
		for (char c : s.toCharArray()) {
			if (c >= 'a' && c <= 'z') {
				lowerCaseLetters++;
			} else if (c >= 'A' && c <= 'Z') {
				higherCaseLetters++;
			} else if (c >= '0' && c <= '9') {
				numbers++;
			}
		}

		out.println(higherCaseLetters);
		out.println(lowerCaseLetters);
		out.println(numbers);

		in.close();
		out.close();
	}
}
