package Y2016A;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/03/26
 * @time 265ms
 * 首次出现 -- a -> -a
 * 非首次出现 -- 记录相同值在两次出现的间隔中的所有元素种数
 * <p>
 * 思路 二刷
 * SegmentTree求区间和
 */
public class PREV_147_2 {
	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer tk = new StringTokenizer(" ");
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	private static final int MAX = 100000 + 10;
	private static int[] nums = new int[MAX];
	private static int[] tree = new int[MAX * 4];
	static int n, maxPoint;

	public static void main(String[] args) throws IOException {
		n = nextInt();
		init();
		int cur;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			cur = nextInt();
			if (map.containsKey(cur)) {
				int preNum = map.get(cur);
				nums[i] = query(preNum + 1, i, 0, 0, maxPoint);
				update(preNum, -1);
			} else {
				nums[i] = -cur;
			}
			map.put(cur, i);
			update(i, 1);
		}

		for (int i = 0; i < n; i++) {
			if (i == n - 1) {
				out.println(nums[i]);
				break;
			}
			out.print(nums[i] + " ");
		}

		close();
	}

	private static int query(int x, int y, int k, int l, int r) {
		if (x == y || x >= r || y <= l) {
			return 0;
		}
		if (x <= l && y >= r) {
			return tree[k];
		}
		int mid = (l + r) >> 1;
		return query(x, y, (k << 1) + 1, l, mid) + query(x, y, (k + 1) << 1, mid, r);
	}

	private static void update(int k, int addNum) {
		k += maxPoint - 1;
		tree[k] += addNum;
		while (k > 0) {
			k = (k - 1) >> 1;
			tree[k] += addNum;
		}
	}

	private static void init() {
		maxPoint = 1;
		while (maxPoint < n) {
			maxPoint <<= 1;
		}
	}

	private static int nextInt() throws IOException {
		while (!tk.hasMoreTokens()) {
			tk = new StringTokenizer(in.readLine());
		}
		return Integer.parseInt(tk.nextToken());
	}

	private static void close() throws IOException {
		in.close();
		out.close();
	}
}
