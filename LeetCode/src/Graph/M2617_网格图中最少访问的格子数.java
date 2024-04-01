package Graph;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Hyperspace
 * @date 2024/03/22
 * @file M2617_网格图中最少访问的格子数.java
 * <p>
 * 思路
 * bfs，双优先队列维护小根堆
 * d[i][j]记录走到(i-1,j-1)所需的最小步数
 * 每次移除堆顶无法一次到达i或j的元素
 * 否则将可以走到的最小步数入队
 */
public class M2617_网格图中最少访问的格子数 {
    public int minimumVisitedCells(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] d = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(d[i], -1);
        }
        d[0][0] = 1;
        PriorityQueue<int[]>[] r = new PriorityQueue[m], c = new PriorityQueue[n];
        for (int i = 0; i < m; i++) {
            r[i] = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        }
        for (int i = 0; i < n; i++) {
            c[i] = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                while (!r[i].isEmpty() && r[i].peek()[1] + grid[i][r[i].peek()[1]] < j) {
                    r[i].poll();
                }
                if (!r[i].isEmpty()) {
                    d[i][j] = update(d[i][j], d[i][r[i].peek()[1]] + 1);
                }

                while (!c[j].isEmpty() && c[j].peek()[1] + grid[c[j].peek()[1]][j] < i) {
                    c[j].poll();
                }
                if (!c[j].isEmpty()) {
                    d[i][j] = update(d[i][j], d[c[j].peek()[1]][j] + 1);
                }

                if (d[i][j] != -1) {
                    r[i].offer(new int[]{d[i][j], j});
                    c[j].offer(new int[]{d[i][j], i});
                }
            }
        }

        return d[m - 1][n - 1];
    }

    public int update(int x, int y) {
        return x == -1 || y < x ? y : x;
    }
}
