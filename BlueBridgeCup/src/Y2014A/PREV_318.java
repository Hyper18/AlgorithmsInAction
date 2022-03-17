package Y2014A;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/03/17
 */
public class PREV_318 {
	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer token = new StringTokenizer("");
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	private static final int MOD = 100000000 + 7;

	public static void main(String[] args) throws IOException {
		int n = nextInt();
		int s = nextInt();
		int a = nextInt();
		int b = nextInt();


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
