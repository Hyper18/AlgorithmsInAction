package Graph;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/05/31
 */
public class Q860_染色法判定二分图 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    /**
     * 使用邻接表存储无向图应开2倍
     */
    private static final int N = (int) 1e5 + 10, M = N * 2;
    private static int[] h = new int[N], e = new int[M], ne = new int[M];
    private static int[] color = new int[N];
    static int n, m, idx;

    private static void addEdge(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public static void main(String[] args) throws IOException {
        n = nextInt();
        m = nextInt();
        Arrays.fill(h, -1);
        while (m-- > 0) {
            int a = nextInt(), b = nextInt();
            addEdge(a, b);
            addEdge(b, a);
        }
        boolean flag = true;
        for (int i = 1; i <= n; i++) {
            // 从n = 1开始，顺次为没有上色的结点染色
            if (color[i] == 0) {
                if (!dfs(i, 1)) {
                    flag = false;
                    break;
                }
            }
        }
        out.println(flag ? "Yes" : "No");
        close();
    }

    private static boolean dfs(int u, int c) {
        color[u] = c;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            // j点的颜色与u点相同
            if (color[j] == c) {
                return false;
            }
            // 若j尚未被染色，判断染3-c色是否合适（对于c=1，3-c=2）
            if (color[j] == 0 && !dfs(j, 3 - c)) {
                return false;
            }
        }

        return true;
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
