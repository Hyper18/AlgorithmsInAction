package Matrix;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Hyperspace
 * @date 2025/05/08
 * @file M3342_到达最后一个房间的最少时间II.java
 * <p>
 * 思路
 * 最短路
 * Q3341变体
 */
public class M3342_到达最后一个房间的最少时间II {
    private final static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private final int INF = Integer.MAX_VALUE;

    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length, m = moveTime[0].length;
        int[][] d = new int[n][m];
        for (int[] row : d) {
            Arrays.fill(row, INF);
        }
        d[0][0] = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        q.add(new int[]{0, 0, 0});
        while (true) {
            int[] p = q.poll();
            int x = p[0], y = p[1], dis = p[2];
            if (x == n - 1 && y == m - 1) {
                return dis;
            }
            if (dis > d[x][y]) {
                continue;
            }
            int time = (x + y) % 2 + 1;
            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                int newDis = Math.max(dis, moveTime[nx][ny]) + time;
                if (newDis < d[nx][ny]) {
                    d[nx][ny] = newDis;
                    q.add(new int[]{nx, ny, newDis});
                }
            }
        }
    }
}
