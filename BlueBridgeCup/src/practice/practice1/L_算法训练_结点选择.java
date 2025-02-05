package practice.practice1;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/03/02
 * <p>
 * 1. 首先考虑如何存放树结点 使用一个二维数组 通过 父 -- 子 保存 但是写完发现输入不是先父后子。。数码了
 * 看了@Plutoaaa题解，参考的思路
 * 2. 使用dfs遍历树节点
 * 3. 考虑状态转移方程
 * <p>
 * 回看
 */

public class L_算法训练_结点选择 {
    final static int MAX = 100005;
    static Edge[] edge = new Edge[MAX * 2];
    static int edgeCount;
    static int[] tree = new int[MAX];
    static int[][] dp = new int[MAX][2];
    static int[] visit = new int[MAX * 2];
    static boolean[] visited = new boolean[MAX];

    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        for (int i = 1; i <= n; ++i) {
            dp[i][1] = in.nextInt();
        }
        Arrays.fill(tree, -1);
        for (int i = 1; i < n; ++i) {
            int x = in.nextInt();
            int y = in.nextInt();
            add(x, y);
            add(y, x);
        }

        dfs(1, 0);
        int ans = Math.max(dp[1][0], dp[1][1]);
        out.println(ans);

        in.close();
        out.close();
    }

    static class Edge {
        int start, end, next;

        Edge(int start, int end, int next) {
            this.start = start;
            this.end = end;
            this.next = next;
        }
    }

    static class InputReader {
        private BufferedReader br;
        private StringTokenizer st;

        InputReader(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
            st = new StringTokenizer("");
        }

        private String next() throws IOException {
            while (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        public Integer nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public void close() {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static void add(int start, int end) {
        edge[edgeCount] = new Edge(start, end, tree[start]);
        tree[start] = edgeCount++;
    }

    static void dfs(int child, int parent) {
        Arrays.fill(visited, false);
        int tmp = 0;
        visited[child] = true;
        visit[tmp++] = child;
        while (tmp > 0) {
            child = visit[tmp - 1];
            boolean edgeVisited = false;
            for (int i = tree[child]; i + 1 != 0; i = edge[i].next) {
                int end = edge[i].end;
                if (visited[end]) {
                    continue;
                }
                edgeVisited = true;
                visit[tmp++] = end;
                visited[end] = true;
            }
            if (edgeVisited) {
                continue;
            }
            --tmp;
            for (int i = tree[child]; i + 1 != 0; i = edge[i].next) {
                int sub = edge[i].end;
                dp[sub][0] += Math.max(dp[child][0], dp[child][1]);
                dp[sub][1] += dp[child][0];
            }
        }
    }
}
