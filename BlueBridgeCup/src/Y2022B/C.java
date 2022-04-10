package Y2022B;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class C {
	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer tk = new StringTokenizer("");
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

	public static void main(String[] args) throws IOException {
		String text = next();
		int[] cnt = new int[26];
		for (char c : text.toCharArray()) {
			cnt[c - 'A']++;
		}

		int max = 0;
		List<Character> ans = new ArrayList<>();
		for (int i = 0; i < 26; i++) {
			if (cnt[i] > max) {
				max = cnt[i];
				if (ans.size() > 0) {
					ans = new ArrayList<>();
				}
				ans.add((char) ('A' + i));
			} else if (cnt[i] == max) {
				ans.add((char) ('A' + i));
			}
		}

		java.util.Collections.sort(ans);
		for (char c : ans) {
			out.print(c);
		}

		close();
	}

	public static String next() throws IOException {
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
