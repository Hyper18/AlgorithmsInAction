package Graph.ShortestPath.Model;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/06/05
 * <p>
 * 思路
 * 一维的bfs求最短路问题
 * Q188的简化，思路一致
 * <p>
 * 注意：
 * 如果起点和终点相同，则此sp case的时间消耗为0
 */
public class Q1100_抓住那头牛 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = (int) 1e5 + 10;
    private static final int[] dx = new int[]{1, -1, 2};
    private static int[] d = new int[N];
    private static boolean[] vis = new boolean[N];

    public static void main(String[] args) throws IOException {
        out.println(bfs(nextInt(), nextInt()));
        close();
    }

    private static int bfs(int st, int ed) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(st);
        vis[st] = true;
        while (!q.isEmpty()) {
            int x = q.poll();
            for (int j : dx) {
                int nx = j == 2 ? x * 2 : x + j;
                if (nx < 0 || nx >= N || vis[nx]) {
                    continue;
                }
                if (nx == ed) {
                    return d[x] + 1;
                }
                vis[nx] = true;
                q.offer(nx);
                d[nx] = d[x] + 1;
            }
        }

        return 0;
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
