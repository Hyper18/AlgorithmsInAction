package practice.practice3;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/03/07
 * @time 328ms
 * 链式向前星+动归
 * 重点：状态转移方程
 * 回看
 */
public class H_算法提高_金属采集 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer token = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static int[] head;
    private static Edge[] edges;
    private static boolean[] visited;
    private static int[][] dp;
    private static int node;
    static int k;

    /**
     * pre：与这条边同起点的上一条边所在结点的编号
     * to：这条边的终点
     * w：weight
     */
    static class Edge {
        int pre, to, w;
    }

    /**
     * @param n 结点数目
     */
    private static void init(int n) {
        // 从1开始编号
        visited = new boolean[n + 1];
        dp = new int[n + 1][k + 1];

        // 无向图
        int size = (n - 1) * 2;
        edges = new Edge[size];
        head = new int[size];
        Arrays.fill(head, -1);
        node = 0;
    }

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int s = nextInt();
        k = nextInt();

        init(n);
        int i = n - 1;
        while (i-- > 0) {
            int a = nextInt();
            int b = nextInt();
            int w = nextInt();
            addEdge(a, b, w);
            addEdge(b, a, w);
        }

        bfs(s);

        out.println(dp[s][k]);

        close();
    }

    private static void bfs(int root) {
        Stack<Integer> stk = new Stack<>();

        stk.push(root);
        visited[root] = true;
        while (!stk.isEmpty()) {
            root = stk.peek();
            int num = find(root);

            if (num == -1) {
                stk.pop();
                if (!stk.isEmpty()) {
                    int node = stk.peek();
                    int w = find(root, node);
                    int to = root;
                    for (int j = k; j >= 0; j--) {
                        dp[node][j] += dp[to][0] + 2 * w;
                        for (int l = 1; l <= j; l++) {
                            dp[node][j] = Math.min(dp[node][j], dp[node][j - l] + dp[to][l] + l * w);
                        }
                    }
                }
            } else {
                visited[num] = true;
                stk.push(num);
            }
        }
    }

    private static int find(int root, int node) {
        for (int i = head[node]; i != -1; i = edges[i].pre) {
            if (edges[i].to == root) {
                return edges[i].w;
            }
        }

        return node;
    }

    private static int find(int root) {
        int num = -1;
        for (int i = head[root]; i != -1; i = edges[i].pre) {
            if (visited[edges[i].to]) {
                continue;
            }
            num = edges[i].to;
            break;
        }

        return num;
    }

    private static void addEdge(int pre, int to, int w) {
        edges[node] = new Edge();
        edges[node].pre = head[pre];
        edges[node].to = to;
        edges[node].w = w;
        head[pre] = node++;
    }

    public static int nextInt() throws IOException {
        while (!token.hasMoreTokens()) {
            token = new StringTokenizer(in.readLine());
        }

        return Integer.parseInt(token.nextToken());
    }

    public static void close() throws IOException {
        in.close();
        out.close();
    }
}
