package Graph.DFS.Model;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/06/08
 * <p>
 * 思路
 * 回溯求搜索次序
 */
public class Q1117_单词接龙 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 20 + 3;
    private static String[] w = new String[N];
    private static int[] cnt = new int[N];
    private static int[][] l = new int[N][N];
    static int n, ans;

    public static void main(String[] args) throws IOException {
        n = nextInt();
        for (int i = 0; i < n; i++) {
            w[i] = next();
        }
        char c = next().charAt(0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int a = w[i].length(), b = w[j].length();
                // 长度必须大于等于1，且严格小于两个串的长度
                for (int k = 1; k < Math.min(a, b); k++) {
                    if (w[i].substring(a - k).equals(w[j].substring(0, k))) {
                        l[i][j] = k;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (c == w[i].charAt(0)) {
                dfs(w[i], i);
            }
        }
        out.println(ans);
        close();
    }

    private static void dfs(String dragon, int last) {
        ans = Math.max(ans, dragon.length());
        cnt[last]++;
        for (int i = 0; i < n; i++) {
            if (l[last][i] != 0 && cnt[i] < 2) {
                // 对符合条件的字符串进行拼接，将w[i]的子串（后半部分子串）拼接至现有串后
                dfs(dragon + w[i].substring(l[last][i]), i);
            }
        }
        // 恢复
        cnt[last]--;
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
