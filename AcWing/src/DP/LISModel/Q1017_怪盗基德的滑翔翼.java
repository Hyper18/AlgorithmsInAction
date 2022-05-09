package DP.LISModel;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/05/09
 * <p>
 * 思路 线性dp
 * 1. 状态表示
 * 集合：f[i]表示到达第i个建筑时所经过的最大建筑数目
 * 属性：Max
 * <p>
 * 2. 状态计算
 * 形如LIS写法，对于可能滑翔的两个方向，
 * 可通过从左至右、从右至左双向的LIS解决
 * 状态转移方程：
 * f[i] = max(f[i], f[j] + 1)
 */
public class Q1017_怪盗基德的滑翔翼 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 100 + 10;
    private static int[] h = new int[N], f = new int[N];

    public static void main(String[] args) throws IOException {
        int k = nextInt();
        while (k-- > 0) {
            int n = nextInt();
            for (int i = 1; i <= n; i++) {
                h[i] = nextInt();
            }

            int ans = 0;
            // 从起始第i个建筑的最左端开始，从左至右地寻找LIS
            for (int i = 1; i <= n; i++) {
                f[i] = 1;
                for (int j = 1; j < i; j++) {
                    // 做Q1014才发现本题条件大于、小于都可以过，很神奇
                    // 可以理解为统计个数，正三角、倒三角次序对结果没有影响
                    if (h[i] > h[j]) {
                        f[i] = Math.max(f[i], f[j] + 1);
                    }
                }
                ans = Math.max(ans, f[i]);
            }

            // 从起始第i个建筑的最右端开始，从右至左地寻找LIS
            for (int i = n; i >= 1; i--) {
                f[i] = 1;
                for (int j = n; j > i; j--) {
                    if (h[i] > h[j]) {
                        f[i] = Math.max(f[i], f[j] + 1);
                    }
                }
                ans = Math.max(ans, f[i]);
            }

            out.println(ans);
        }

        close();
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
