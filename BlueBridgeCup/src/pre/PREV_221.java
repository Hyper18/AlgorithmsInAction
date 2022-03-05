package pre;

import java.io.BufferedInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Hyperspace
 * @date 2022/03/05
 */
public class PREV_221 {
	private static int[] pre;
	private static int cnt = 0;
	private final static int MAXN = 1000007;

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		int m = in.nextInt();
		int n = in.nextInt();
		int k = in.nextInt();

		cnt = m * n;
		pre = new int[MAXN];
		for (int i = 1; i <= cnt; i++) {
			pre[i] = i;
		}

		for (int i = 0; i < k; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			join(a, b);
		}

		out.println(cnt);

		in.close();
		out.close();
	}

	private static int find(int root) {
		while (root != pre[root]) {
			root = pre[root];
		}

		return root;
	}

	private static void join(int a, int b) {
		int root1 = find(a);
		int root2 = find(b);

		if (root1 != root2) {
			pre[root1] = root2;
			cnt--;
		}
	}
}
