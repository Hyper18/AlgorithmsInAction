package Y2022B;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class E {
	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer tk = new StringTokenizer("");
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	private static BigInteger ONE = BigInteger.valueOf(1);

	public static void main(String[] args) throws IOException {
		long k = nextLong();
		long num = 1L;
		while (true) {
			long f = num;
			BigInteger base = BigInteger.valueOf(num);
			while (f-- > 1) {
				base = base.multiply(BigInteger.valueOf(f));
			}
			if (check(base, k)) {
				out.println(num);
				close();
				return;
			}
			num++;
		}
	}

	private static boolean check(BigInteger base, long k) {
		String s = String.valueOf(base);
		long cnt = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) != '0') {
				break;
			}
			cnt++;
		}
		return cnt == k;
	}

	public static long nextLong() throws IOException {
		while (!tk.hasMoreTokens()) {
			tk = new StringTokenizer(in.readLine());
		}
		return Long.parseLong(tk.nextToken());
	}

	public static void close() throws IOException {
		in.close();
		out.close();
	}
}
