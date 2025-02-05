package Graph.DFS;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/05/24
 * <p>
 * 思路
 * 通过数组建立邻接链表
 * e[i]：存储从1 ~ n的结点编号
 * idx：指示结点的下标，即在数组中的索引位置
 * ne[i]：存储下标为i的下一个结点的下标
 * h[i]：存储编号为i的下一个结点的下标
 */
public class Q846_树的重心 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = (int) 1e5 + 10, M = N * 2;
    private static int[] h = new int[N], e = new int[M], ne = new int[M];
    private static boolean[] vis = new boolean[N];
    static int n, idx, ans = N;

    public static void main(String[] args) throws IOException {
        n = nextInt();
        Arrays.fill(h, -1);
        for (int i = 0; i < n - 1; i++) {
            int a = nextInt(), b = nextInt();
            addEdge(a, b);
            addEdge(b, a);
        }
        dfs(1);
        out.println(ans);
        close();
    }

    private static int dfs(int u) {
        vis[u] = true;

        int size = 0, sum = 0;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (vis[j]) {
                continue;
            }

            int s = dfs(j);
            size = Math.max(size, s);
            sum += s;
        }
        size = Math.max(size, n - (sum + 1));
        ans = Math.min(ans, size);

        return sum + 1;
    }

    private static void addEdge(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
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
