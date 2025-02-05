package practice.practice3;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/03/07
 * 1. 暴力模拟 50/100，内存会超
 * 2. 线段树
 */
public class J_压缩变换2 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer token = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int MAXN = 100000 + 7;
    private static int[] nums = new int[MAXN];
    private static int[] tree = new int[MAXN * 4];
    private static int n, maxPoint;

    private static void init() {
        maxPoint = 1;
        // 比最后一个结点大的2的倍数个结点
        while (maxPoint < n) {
            maxPoint <<= 1;
        }
        Arrays.fill(nums, 0);
        Arrays.fill(tree, 0);
    }

    public static void main(String[] args) throws IOException {
        n = nextInt();
        init();
        Map<Integer, Integer> map = new HashMap<>();
        int cur;
        for (int i = 0; i < n; i++) {
            cur = nextInt();
            if (map.containsKey(cur)) {
                int preNum = map.get(cur);
                nums[i] = query(preNum + 1, i, 0, 0, maxPoint);
                update(preNum, -1);
            } else {
                nums[i] = Math.negateExact(cur);
            }
            map.put(cur, i);
            update(i, 1);
        }

        for (int i = 0; i < n; i++) {
            out.print(nums[i] + " ");
        }

        close();
    }

    /**
     * addNum 在出现前边时更新所有子节点 + 1， 出现后边时 所有子节点都 - 1
     *
     * @param k      结点
     * @param addNum 更新值
     */
    private static void update(int k, int addNum) {
        k += maxPoint - 1;
        tree[k] += addNum;
        // 访问父结点直到根结点
        while (k > 0) {
            k = (k - 1) >> 1;
            tree[k] += addNum;
        }
    }

    private static int query(int x, int y, int k, int l, int r) {
        if (x == y || (r <= x || l >= y)) {
            return 0;
        }
        if (x <= l && r <= y) {
            return tree[k];
        } else {
            int m = (l + r) >> 1;
            return query(x, y, (k << 1) + 1, l, m) + query(x, y, (k + 1) << 1, m, r);
        }
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
