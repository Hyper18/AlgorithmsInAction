package Y2016C;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/03/29
 * 33/100
 */
public class PREV_145 {
	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer tk = new StringTokenizer(" ");
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

	public static void main(String[] args) throws IOException {
		String str = nextString();
		int ans = dfs(str, 0, str.length() - 1, 0);
		out.println(ans);
		close();
	}

	private static int dfs(String str, int left, int right, int cnt) {
		if (left >= right) {
			return cnt;
		}
		if (str.charAt(left) != str.charAt(right)) {
			return Math.min(dfs(str, left + 1, right, cnt + 1), dfs(str, left, right - 1, cnt + 1));
		} else {
			return dfs(str, left + 1, right - 1, cnt);
		}
	}

	public static String nextString() throws IOException {
		while (!tk.hasMoreTokens()) {
			tk = new StringTokenizer(in.readLine());
		}
		return tk.nextToken();
	}

	public static void close() throws IOException {
		in.close();
		out.close();
	}
}
