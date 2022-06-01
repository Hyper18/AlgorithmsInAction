package Graph;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/06/01
 */
public class Q861_二分图的最大匹配 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 500 + 10, M = (int) 1e5 + 10;
    private static int[] h = new int[N], e = new int[M], ne = new int[M];
    private static int[] match = new int[N];
    private static boolean[] vis = new boolean[N];
    static int idx;

    private static void addEdge(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public static void main(String[] args) throws IOException {
        // 采用邻接表存储，实际上没有使用到n2
        int n1 = nextInt(), n2 = nextInt(), m = nextInt();
        Arrays.fill(h, -1);
        while (m-- > 0) {
            int a = nextInt(), b = nextInt();
            addEdge(a, b);
        }

        int ans = 0;
        for (int i = 1; i <= n1; i++) {
            if (find(i)) {
                // 重新更新访问状态，以保证能找到最大状态
                vis = new boolean[N];
                ans++;
            }
        }
        out.println(ans);

        close();
    }

    private static boolean find(int x) {
        for (int i = h[x]; i != -1; i = ne[i]) {
            int j = e[i];
            if (vis[j]) {
                continue;
            }
            vis[j] = true;
            if (match[j] == 0 || find(match[j])) {
                match[j] = x;
                return true;
            }
        }

        return false;
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
