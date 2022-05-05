package LinearDP;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/05/05
 * <p>
 * 思路
 * 1. 状态表示
 * 集合：所有将a[1~i]变为b[1~i]的操作方式
 * 属性：min
 * <p>
 * 2. 状态计算
 * 不操作：  f[i][j] = f[i - 1][j - 1]
 * 操作1 删：f[i][j] = f[i - 1][j] + 1
 * 操作2 增：f[i][j] = f[i][j - 1] + 1
 * a的1~i已经和b的1~j-1匹配了，此时a新增一个字符与b的当前最后一位字符匹配
 * 操作3 改：f[i][j] = f[i - 1][j - 1] + 1
 */
public class Q902_最短编辑距离 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 1000 + 10;
    private static char[] a = new char[N], b = new char[N];
    private static int[][] f = new int[N][N];

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        a = next().toCharArray();
        int m = nextInt();
        b = next().toCharArray();
        // 初始化：f[0][i]需进行新增操作i次，f[i][0]需进行删除操作i次
        for (int i = 0; i <= m; i++) {
            f[0][i] = i;
        }
        for (int i = 0; i <= n; i++) {
            f[i][0] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a[i - 1] == b[j - 1]) {
                    f[i][j] = f[i - 1][j - 1];
                } else {
                    f[i][j] = Math.min(Math.min(f[i - 1][j], f[i][j - 1]), f[i - 1][j - 1]) + 1;
                }
            }
        }

        out.println(f[n][m]);

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
