package Y2022B;

import java.io.*;
import java.util.*;

public class D {
	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer tk = new StringTokenizer("");
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

	public static void main(String[] args) throws IOException {
		int n = nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = nextInt();
		}

		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int higher = 0;
			int lower = 0;
			Set<Integer> hstu = new HashSet<>();
			for (int j = 0; j < nums.length; j++) {
				if (i == j) {
					continue;
				}
				if (nums[i] < nums[j]) {
					higher++;
					hstu.add(nums[j]);
				} else if (nums[i] > nums[j]) {
					lower++;
				}
			}
			if (higher <= lower) {
				res.add(0);
			} else {
				int diff = higher - lower;
				List<Integer> list = new ArrayList<>(hstu);
				Collections.sort(list);
				int ans = list.get(Math.max(0, diff % 2 == 0 ? diff / 2 - 1 : diff / 2)) - nums[i] + 1;
				res.add(ans);
			}
		}

		for (int i = 0; i < res.size(); i++) {
			if (i == res.size() - 1) {
				out.println(res.get(i));
				break;
			}
			out.print(res.get(i) + " ");
		}

		close();
	}

	public static int nextInt() throws IOException {
		while (!tk.hasMoreTokens()) {
			tk = new StringTokenizer(in.readLine());
		}
		return Integer.parseInt(tk.nextToken());
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
