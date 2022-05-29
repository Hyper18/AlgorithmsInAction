package BFS;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/05/29
 * <p>
 * 思路
 * 先找到所有入度为0的结点入队，依次进行广搜；
 * 删除先前的边，若此时结点入度降为0，则入队；
 * 重复上述过程，直到找到拓扑序列的结果
 * <p>
 * 优化
 * 使用一维数组作为队列进行存储，加快访问速度
 */
public class Q848_有向图的拓扑序列 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = (int) 1e5 + 10;
    private static int[] h = new int[N], e = new int[N], ne = new int[N];
    private static int[] d = new int[N], q = new int[N];
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
            // 为每一个输入结点统计入度
            d[b]++;
        }
        if (topSort()) {
            for (int i = 0; i < n; i++) {
                out.print(q[i] + " ");
            }
        } else {
            out.print(-1);
        }
        close();
    }

    private static boolean topSort() {
        int hh = 0, tt = -1;
        for (int i = 1; i <= n; i++) {
            if (d[i] == 0) {
                q[++tt] = i;
            }
        }

        while (hh <= tt) {
            int u = q[hh++];
            for (int i = h[u]; i != -1; i = ne[i]) {
                int j = e[i];
                if (--d[j] == 0) {
                    q[++tt] = j;
                }
            }
        }

        return tt == n - 1;
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
