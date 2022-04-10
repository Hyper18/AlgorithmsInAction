package Y2022B;

import java.io.*;
import java.util.*;

public class G {
	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer tk = new StringTokenizer("");
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	private static final int MOD = 1000000007;
	private static int[] nums;
	static int n;

	public static void main(String[] args) throws IOException {
		n = nextInt();
		nums = new int[n];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			nums[i] = nextInt();
			sb.append(nums[i]);
		}

		String str = sb.toString();
		Set<String> divs = new HashSet<>();
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				divs.add(str.substring(i, j + 1));
			}
		}

		int ans = 2; // ȫ���� ȫ��
		for (String div1 : divs) {
			for (String div2 : divs) {
				if (div1.equals(div2) && div1.length() + div2.length() != n) {
					continue;
				}
				String div3 = div1 + div2;
				if (!checkPos(div3)) {
					continue;
				}
				if (check(div1) && check(div2) && check(div3)) {
//					out.printf("%s %s %s\n", div1, div2, div3);
					ans++;
				}
			}
		}

		out.println(1 + ans);

		close();
	}

	private static boolean checkPos(String div) {
		if (div.length() != n) {
			return false;
		}
		char[] arr = div.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			int num = Integer.parseInt(String.valueOf(arr[i]));
			if (num != nums[i]) {
				return false;
			}
		}
		return true;
	}

	private static boolean check(String div) {
		if (div.length() == 1) {
			return true;
		}
		List<Integer> list = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		for (char c : div.toCharArray()) {
			int num = Integer.parseInt(String.valueOf(c));
			if (!set.add(num)) {
				return false;
			}
			list.add(num);
		}

		java.util.Collections.sort(list);
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i) - list.get(i - 1) != 1) {
				return false;
			}
		}
		return true;
	}

	public static int nextInt() throws IOException {
		while (!tk.hasMoreTokens()) {
			tk = new StringTokenizer(in.readLine());
		}
		return Integer.parseInt(tk.nextToken());
	}

	public static void close() throws IOException {
		in.close();
		out.close();
	}
}
