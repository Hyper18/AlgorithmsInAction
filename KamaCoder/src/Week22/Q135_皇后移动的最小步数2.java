package Week22;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Hyper
 * @date 2024/12/11
 * @file Q135_皇后移动的最小步数2.java
 * <p>
 * 题目描述
 * 有一个 n 行 m 列的棋盘，有一些格子是障碍物不能通过。
 * 小红控制一个皇后在从左上角出发，每次移动她可以控制皇后进行以下三种方式中的一种:
 * 1.向右移动若干个格子。
 * 2.向下移动若干个格子。
 * 3.向右下移动若干个格子。
 * 用数学语言描述，当前的坐标在 (x, y) 时，
 * 每次移动可以到 (x + k, y) 或 (x, y + k) 或 (x + k, y + k) 其中 k 为任意正整数。
 * 移动的前提是，路径上没有障碍物。
 * 小红想知道，皇后从左上角移动到右下角，最少要移动多少步?
 * <p>
 * 输入描述
 * 第一行输入两个正整数 n 和 m（1 <= n,m <= 2000），代表行数和列数。
 * 接下来的 n 行，每行输入一个长度 m 的字符串，用来表示棋盘。
 * 其中 "." 代表可以通过的位置，"*" 代表障碍物。 保证左上角和右下角都不是障碍物。
 * <p>
 * 输出描述
 * 如果无法到达，请输出-1。
 * 否则输出一个整数，代表最少的移动次数。
 * <p>
 * 思路
 * bfs
 * 和一般的广搜不同的是需要考虑连续走的情况
 * 即对于移动距离k
 * {k, 0}, {0, k}, {k, k}三种情况
 * 移动的步数均为1
 */
public class Q135_皇后移动的最小步数2 {
    private static final int[][] dirs = new int[][]{{1, 0}, {0, 1}, {1, 1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        char[][] g = new char[n][m];
        boolean[][] vis = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            g[i] = sc.next().toCharArray();
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0});
        vis[0][0] = true;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int x = p[0], y = p[1], d = p[2];
            if (x == n - 1 && y == m - 1) {
                System.out.println(d);
                return;
            }
            for (int[] dir : dirs) {
                int nx = x, ny = y;
                while (nx + dir[0] >= 0 && nx + dir[0] < n && ny + dir[1] >= 0 && ny + dir[1] < m && g[nx + dir[0]][ny + dir[1]] == '.') {
                    nx += dir[0];
                    ny += dir[1];
                    if (!vis[nx][ny]) {
                        vis[nx][ny] = true;
                        q.offer(new int[]{nx, ny, d + 1});
                    }
                }
            }
            vis[x][y] = true;
        }
        System.out.println(-1);
    }
}
