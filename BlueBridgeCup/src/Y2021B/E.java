package Y2021B;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class E {
    static class Edge {
        int to;
        int len;

        public Edge(int to, int len) {
            super();
            this.to = to;
            this.len = len;
        }
    }

    private static final int N = 2021 + 10;
    private static final int INF = 0x3f3f3f3f;
    private static List<Edge>[] graph = new List[N];

    public static void main(String[] args) {
        for (int i = 1; i <= 2021; i++) {
            for (int j = i + 1; j <= 2021; j++) {
                if (Math.abs(i - j) > 21) {
                    break;
                }
                int dis = lcm(i, j);
                if (graph[i] == null) {
                    graph[i] = new ArrayList<>();
                }
                if (graph[j] == null) {
                    graph[j] = new ArrayList<>();
                }
                graph[i].add(new Edge(j, dis));
                graph[j].add(new Edge(i, dis));
            }
        }

        System.out.println(dijkstra(1, 2021));
    }

    private static int dijkstra(int st, int ed) {
        PriorityQueue<Edge> queue = new PriorityQueue<>((a, b) -> Integer.compare(a.len, b.len));
        boolean[] vis = new boolean[N];
        int[] dis = new int[N];
        Arrays.fill(dis, INF);

        dis[st] = 0;
        queue.offer(new Edge(st, dis[st]));
        while (!queue.isEmpty()) {
            int from = queue.poll().to;
            if (vis[from]) {
                continue;
            }
            vis[from] = true;
            for (Edge nextEdge : graph[from]) {
                int to = nextEdge.to;
                int len = nextEdge.len;
                if (dis[to] > dis[from] + len) {
                    dis[to] = dis[from] + len;
                    queue.offer(new Edge(to, dis[to]));
                }
            }
        }

        return dis[ed];
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
