package DP.Knapsack;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/05/11
 * <p>
 * 思路 求最大的线性无关组 -- 类似素数筛做法
 * 完全背包的方案数变体，
 * 若当前方案能满足，则放入
 * 不满足，则不含在最优解内
 * <p>
 * 1. 状态表示
 * 原题等价于 求出 货币系统 (n,a)的 最大无关向量组，即任意 ai 都不能被其他向量 线性表出
 * 集合：f[i][j]表示对i个物品，当前体积为j的方案数
 * 这里的背包体积应当等于最大币值，即数据量上限为 N = 25000
 * 属性：当前方案是否成立
 * 2. 状态计算
 * 不选i（全不选，1） ~ 选n个i（不变， n）
 * f[j] |= f[j - a[i]]
 * <p>
 * 注：与f[j] += f[j - a[i]]的区别
 * 前者是可行性背包，求解状态的真值，后者是背包方案数，求解状态的可达方案数。
 */
public class Q532_货币系统 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 25000 + 10;
    private static int[] a = new int[N];
    private static boolean[] f = new boolean[N];

    public static void main(String[] args) throws IOException {
        int t = nextInt();
        while (t-- > 0) {
            int n = nextInt();
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }

            Arrays.sort(a, 0, n);
            // 每次应重新初始化
            Arrays.fill(f, false);
            f[0] = true;
            int ans = 0, m = a[n - 1];
            for (int i = 0; i < n; i++) {
                if (!f[a[i]]) {
                    ans++;
                }
                for (int j = a[i]; j <= m; j++) {
                    f[j] |= f[j - a[i]];
                }
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
