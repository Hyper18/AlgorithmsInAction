package Graph.BFS;

import java.io.*;
import java.util.*;

/**
 * @author Hyper
 * @date 2022/05/26
 * <p>
 * 思路
 * 字符串 回溯
 * 将二维问题（3*3棋盘）转化为一维问题（字符串）
 */
public class Q845_八数码 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 3;
    private static final String STR = "12345678x";
    private static int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private static Map<String, Integer> dis = new HashMap<>();

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(next());
            }
        }
        out.println(bfs(sb.toString()));
        close();
    }

    private static int bfs(String st) {
        Queue<String> q = new LinkedList<>();
        q.offer(st);
        while (!q.isEmpty()) {
            String str = q.poll();
            int d = dis.getOrDefault(str, 0);
            if (STR.equals(str)) {
                return d;
            }
            int k = str.indexOf('x');
            int x = k / N, y = k % N;
            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }
                str = swap(str, k, nx * 3 + ny);
                if (!dis.containsKey(str)) {
                    dis.put(str, d + 1);
                    q.offer(str);
                }
                str = swap(str, k, nx * 3 + ny);
            }
        }

        return -1;
    }

    private static String swap(String s, int i, int j) {
        char[] str = s.toCharArray();
        char t = str[i];
        str[i] = str[j];
        str[j] = t;
        return String.valueOf(str);
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
