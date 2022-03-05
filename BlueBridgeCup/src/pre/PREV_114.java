package pre;

import java.io.BufferedInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Hyperspace
 * @date 2022/03/05
 */
public class PREV_114 {
	private static int[] pre;
	private static Bridge[] bridges;
	private final static int MAXN = 10007;
	private final static int MAXM = 100007;

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		int n = in.nextInt();
		int m = in.nextInt();

		init(n);
		for (int i = 1; i <= m; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int t = in.nextInt();

			bridges[i] = new Bridge(a, b, t);
		}

		int ans = 0;
		int preDay = 0;
		for (int i = 1; i <= m; i++) {
			int island1 = bridges[i].a;
			int island2 = bridges[i].b;
			if (join(island1, island2) && preDay != bridges[i].t) {
				ans++;
				preDay = bridges[i].t;
			}
		}

		out.println(ans);

		in.close();
		out.close();
	}

	private static void init(int n) {
		pre = new int[MAXN];
		bridges = new Bridge[MAXM];

		for (int i = 1; i <= n; i++) {
			pre[i] = i;
		}
	}

	private static int find(int key) {
		while (pre[key] != key) {
			key = pre[key];
		}

		return key;
	}

	private static boolean join(int a, int b) {
		int island1 = find(a);
		int island2 = find(b);

		if (island1 != island2) {
			pre[island1] = island2;
			return true;
		}

		return false;
	}
}

class Bridge implements Comparable<Bridge> {
	int a;
	int b;
	int t;

	public Bridge(int a, int b, int t) {
		super();
		this.a = a;
		this.b = b;
		this.t = t;
	}

	@Override
	public int compareTo(Bridge bridge) {
		return this.t - bridge.t;
	}
}
