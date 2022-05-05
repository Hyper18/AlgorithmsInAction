package LinearDP;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/05/05
 * <p>
 * 思路
 * 1. 状态表示：f[i][j] 字串A在i结尾、字串B在j结尾时的最大公共子串长度
 * 2. 状态计算：
 * 1) 当子串此时末尾的数值相等时，长度+1
 * f[i][j] = f[i - 1][j - 1] + 1
 * 2) 不相等时，选择两串中的较长子串
 * f[i][j] = Math.max(f[i - 1][j], f[i][j - 1])
 */
public class Q897_最长公共子序列 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 1000 + 10;
    private static int[][] f = new int[N][N];

    public static void main(String[] args) throws IOException {
        int n = nextInt(), m = nextInt();
        char[] a = next().toCharArray(), b = next().toCharArray();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a[i - 1] == b[j - 1]) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                } else {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
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
