package Y2013A;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/03/14
 * @time 156ms
 * 找无向图的直径
 * 不用邻接矩阵了，换用邻接表
 */
class Node {
    int idx;
    int dis;

    public Node(int idx, int dis) {
        this.idx = idx;
        this.dis = dis;
    }
}

public class PREV_291大臣的旅费2 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer token = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static List<Node>[] graph;
    static int n, cityIdx, max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        n = nextInt();
        graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            int p = nextInt();
            int q = nextInt();
            int d = nextInt();
            graph[p].add(new Node(q, d));
            graph[q].add(new Node(p, d));
        }

        dfs(1, 1, 0);
        dfs(cityIdx, cityIdx, 0);

        out.println(getDistance(max));

        close();
    }

    private static void dfs(int from, int cur, int dis) {
        boolean isLeaf = true;
        List<Node> neighbors = graph[cur];
        for (Node neighbor : neighbors) {
            if (neighbor.idx == from) {
                continue;
            }
            isLeaf = false;
            dfs(cur, neighbor.idx, dis + neighbor.dis);
        }
        if (isLeaf && dis > max) {
            max = dis;
            cityIdx = cur;
        }
    }

    private static int getDistance(int n) {
        return n * 11 + n * (n - 1) / 2;
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
