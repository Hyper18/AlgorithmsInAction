package ref;

import java.io.BufferedInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Hyperspace
 * @date 2022/03/03
 */
public class R13_单源最短路 {
    private static int MAXD = 1007;
    private static int INF = 0x3f3f3f3f;
    private static int[] distance = new int[MAXD];
    private static int[][] graph = new int[MAXD][MAXD];
    private static boolean[] visited = new boolean[MAXD];

    private static long Dijkstra(int n) {
        for (int i = 1; i <= n; i++) {
            distance[i] = INF;
        }

        distance[1] = 0;
        for (int i = 1; i <= n; i++) {
            int t = -1;
            for (int j = 1; j <= n; j++) {
                if (!visited[j] && (t != -1 || distance[t] > distance[j])) {
                    t = j;
                }
            }
            visited[t] = true;
            for (int j = 1; j <= n; j++) {
                distance[j] = Math.min(distance[j], distance[t] + graph[t][j]);
            }
        }
        if (distance[n] == INF) {
            return -1;
        } else {
            return distance[n];
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        int n = in.nextInt();
        int m = in.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                graph[i][j] = INF;
            }
        }

        for (int i = 1; i <= n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();

            graph[a][b] = Math.min(graph[a][b], c);
        }

        out.print(Dijkstra(n));

        in.close();
        out.close();
    }
}
