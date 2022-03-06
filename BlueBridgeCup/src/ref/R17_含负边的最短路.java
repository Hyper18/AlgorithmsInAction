package ref;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Hyperspace
 * @date 2022/03/06
 * S P F A 算法
 */
public class R17_含负边的最短路 {
    private static int MAXD = 100000 + 7;
    private static int INF = 0x3f3f3f3f;
    private static int[] distance = new int[MAXD];
    private static int[] head = new int[MAXD];
    private static int[] edgePre = new int[MAXD];
    private static int[] edgeW = new int[MAXD];
    private static int[] edgeTo = new int[MAXD];
    private static int[] num = new int[MAXD];
    private static boolean[] visited = new boolean[MAXD];
    private static int node;

    public static void init(int n, int m) {
        Arrays.fill(head, -1);
        Arrays.fill(distance, INF);
        node = 0;
    }

    private static void addEdge(int a, int b, int w) {
        edgePre[node] = head[a];
        edgeTo[node] = b;
        edgeW[node] = w;
        head[a] = node++;
    }

    public static boolean SPFA(int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        distance[1] = 0;
        num[1] = 1;
        visited[1] = true;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            visited[u] = false;
            for (int i = head[u]; i != -1; i = edgePre[i]) {
                int v = edgeTo[i];
                if (distance[v] <= distance[u] + edgeW[i]) {
                    continue;
                }
                distance[v] = distance[u] + edgeW[i];
                num[v] = num[u] + 1;
                if (num[v] > end) {
                    return true;
                }
                if (!visited[v]) {
                    visited[v] = true;
                    queue.offer(v);
                }
            }
        }

        return false;
    }
}
