package practice.practice1;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/03/06
 * @aeroplanes 思路
 * @time 312ms
 * 因为需要处理负权值边，因此无法采用朴素迪杰斯特拉算法处理
 * 注：大数据量使用Scanner会超时。。
 */
public class M_算法训练_最短路 {
    static int n, m;
    static final int INF = 0x3f3f3f3f;
    static int[] distance;
    static int[] u, v, w;
    static int[] head, next;
    static boolean[] visited;
    static BufferedReader in;
    static StringTokenizer token;

    public static void main(String[] args) throws Exception {
        in = new BufferedReader(new InputStreamReader(System.in));
        token = new StringTokenizer("");
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        n = nextInt();
        m = nextInt();

        init();

        for (int i = 0; i < m; i++) {
            u[i] = nextInt();
            v[i] = nextInt();
            w[i] = nextInt();
            next[i] = head[u[i]];
            head[u[i]] = i;
        }

        spfa();

        for (int i = 2; i <= n; i++) {
            out.println(distance[i]);
        }

        in.close();
        out.close();
    }

    private static void spfa() {
        distance[1] = 0;
        Queue<Integer> queue = new PriorityQueue<>();
        queue.offer(1);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            visited[u] = false;
            for (int e = head[u]; e != -1; e = next[e]) {
                int tmp = distance[u] + w[e];
                if (distance[v[e]] > tmp) {
                    distance[v[e]] = tmp;
                    if (!visited[v[e]]) {
                        queue.offer(v[e]);
                        visited[v[e]] = true;
                    }
                }
            }
        }
    }

    private static int nextInt() throws IOException {
        while (!token.hasMoreTokens()) {
            token = new StringTokenizer(in.readLine());
        }

        return Integer.parseInt(token.nextToken());
    }

    private static void init() {
        distance = new int[n + 1];
        u = new int[m + 1];
        v = new int[m + 1];
        w = new int[m + 1];
        head = new int[n + 1];
        next = new int[m + 1];
        visited = new boolean[n + 1];

        Arrays.fill(head, -1);
        Arrays.fill(distance, INF);
    }
}
