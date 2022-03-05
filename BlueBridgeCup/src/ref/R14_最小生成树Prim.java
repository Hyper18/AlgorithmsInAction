package ref;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Hyperspace
 * @date 2022/03/05
 */
public class R14_最小生成树Prim {
    private static int MAXD = 100007;
    private static int INF = 0x3f3f3f3f;
    private static int[] distance = new int[MAXD];
    private static int[] head = new int[MAXD];
    private static int[] edgePre = new int[MAXD * 2];
    private static int[] edgeW = new int[MAXD * 2];
    private static int[] edgeTo = new int[MAXD * 2];
    private static boolean[] visited = new boolean[MAXD];
    private static int node;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int n = in.nextInt();
        int m = in.nextInt();

        init(n);

        while (m-- > 0) {
            int a = in.nextInt();
            int b = in.nextInt();
            int w = in.nextInt();

            addEdge(a, b, w);
            addEdge(b, a, w);
        }

        int ans = prim(n);

        out.print(ans == INF ? "Not Found" : ans);

        in.close();
        out.close();
    }

    private static void init(int n) {
        Arrays.fill(distance, INF);
        Arrays.fill(visited, false);
        Arrays.fill(head, -1);
        node = 0;
    }

    private static void addEdge(int a, int b, int w) {
        edgePre[node] = head[a];
        edgeTo[node] = b;
        edgeW[node] = w;

        head[a] = node++;
    }

    private static int prim(int n) {
        int res = 0;

        for (int i = 1; i <= n; i++) {
            int t = -1;
            for (int j = 1; j <= n; j++) {
                if (!visited[j] && (t != -1 || distance[t] > distance[j])) {
                    t = j;
                }
            }
            visited[t] = true;
            if (i != 1 && distance[t] == INF) {
                return INF;
            }
            if (i != -1) {
                res += distance[t];
            }
            for (int j = head[t]; j != -1; j = edgePre[j]) {
                int to = edgeTo[j];
                distance[to] = Math.min(distance[to], edgeW[j]);
            }
        }

        return res;
    }
}
