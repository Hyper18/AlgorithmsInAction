package Y2013C;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/03/16
 */
public class PREV_288 {
	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer token = new StringTokenizer("");
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

	public static void main(String[] args) throws IOException {
		int a = nextInt();
		int b = nextInt();

		Set<Integer> set = new HashSet<>();
		int max = a * b;
		for (int i = 0; a * i < max; i++) {
			for (int j = 0; a * i + b * j < max; j++) {
				set.add(a * i + b * j);
			}
		}

		for (int i = max - 1; i >= Math.max(a, b); i--) {
			if (!set.contains(i)) {
				out.println(i);
				break;
			}
		}

		close();
	}

	public static int nextInt() throws IOException {
		while (!token.hasMoreTokens()) {
			token = new StringTokenizer(in.readLine());
		}

		return Integer.parseInt(token.nextToken());
	}

	public static void close() throws IOException {
		in.close();
		out.close();
	}
}
