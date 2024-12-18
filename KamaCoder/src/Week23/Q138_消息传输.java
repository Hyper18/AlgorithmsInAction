package Week23;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Hyperspace
 * @date 2024/12/16
 * @file Q138_消息传输.java
 * <p>
 * 题目描述
 * 在给定的 m x n (1 <= m, n <= 1000) 网格地图 grid 中，分布着一些信号塔，用于区域间通信。
 * 每个单元格可以有以下三种状态：
 * 值 0 代表空地，无法传递信号；
 * 值 1 代表信号塔 A，在收到消息后，信号塔 A 可以在 1ms 后将信号发送给上下左右四个方向的信号塔；
 * 值 2 代表信号塔 B，在收到消息后，信号塔 B 可以在 2ms 后将信号发送给上下左右四个方向的信号塔。
 * 给定一个坐标 (j, k)，输入保证坐标 (j, k) 位置一定有信号塔。在坐标 (j, k) 位置的信号塔触发一个信号。
 * 要求返回网格地图中所有信号塔收到信号的最短时间，单位为 ms。如果有信号塔无法收到信号，则返回 -1。
 * <p>
 * 输入描述
 * 第一行：网格的列数 n。
 * 第二行：网格的行数 m。
 * 第三行：触发信号的信号塔坐标 (j, k)。
 * 接下来的 m 行：
 * 每行包含 n 个整数，表示该行网格中每个位置的信号塔安装信息（通过空格间隔每个状态值）。
 * <p>
 * 输出描述
 * 输出返回 网格地图中所有信号塔收到信号的最小时间，单位为ms。如果不可能，返回-1。
 * <p>
 * 思路
 * bfs
 * <p>
 * 注意时间的保存
 * 可以为每个位置保留一个最短时间times，替换常见的vis
 */
public class Q138_消息传输 {
    private static final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int sx = sc.nextInt(), sy = sc.nextInt();
        int[][] g = new int[m][n];
        int[][] times = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(times[i], -1);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = sc.nextInt();
            }
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sx, sy, 0});
        times[sx][sy] = 0;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int x = p[0], y = p[1], t = p[2];
            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || g[nx][ny] == 0) {
                    continue;
                }
                int nt = t + (g[x][y] == 1 ? 1 : 2);
                if (times[nx][ny] == -1 || times[nx][ny] > nt) {
                    times[nx][ny] = nt;
                    q.offer(new int[]{nx, ny, nt});
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (times[i][j] == -1 && (g[i][j] == 1 || g[i][j] == 2)) {
                    System.out.println(-1);
                    return;
                }
                ans = Math.max(ans, times[i][j]);
            }
        }
        System.out.println(ans);
    }
}
