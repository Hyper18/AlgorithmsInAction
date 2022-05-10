package DP.LISModel;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/05/10
 * <p>
 * 思路 线性dp -- O(n^2)
 * 1. 状态表示
 * 集合：f[i][j]代表所有a[1 ~ i]和b[1 ~ j]中以b[j]结尾的公共上升子序列的集合
 * 属性：等于该集合的子序列中长度的最大值Max
 * 2. 状态计算
 * 1）不包含a[i]的子集，最大值是f[i - 1][j]
 * 2）包含a[i]的子集
 * 继续划分，依据是子序列的倒数第二个元素在b[]中是哪个数
 * preMax是满足a[i] > b[k]的f[i - 1][j] + 1的前缀最大值
 * <p>
 * 待回看
 */
public class Q272_最长公共上升子序列 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 3000 + 10;
    private static int[] a = new int[N], b = new int[N];
    private static int[][] f = new int[N][N];

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = nextInt();
        }
        for (int i = 1; i <= n; i++) {
            b[i] = nextInt();
        }

        for (int i = 1; i <= n; i++) {
            int preMax = 1;
            for (int j = 1; j <= n; j++) {
                f[i][j] = f[i - 1][j];
                if (a[i] == b[j]) {
                    f[i][j] = Math.max(f[i][j], preMax);
                }
                if (a[i] > b[j]) {
                    preMax = Math.max(preMax, f[i - 1][j] + 1);
                }
            }
        }

        out.println(Arrays.stream(f[n]).max().getAsInt());

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
