package Week21;

import java.util.Scanner;

/**
 * @author Hyperspace
 * @date 2024/12/02
 * @file Q131_小美的字符串变换.java
 * <p>
 * 题目描述
 * 小美拿到了一个长度为 n 的字符串，她希望将字符串从左到右平铺成一个矩阵
 * （先平铺第一行，然后是第二行，以此类推，
 * 矩阵有 x 行 y 列，必须保证 x * y=n，即每 y 个字符换行，共 x 行）。
 * 该矩阵的权值定义为这个矩阵的连通块数量。
 * 小美希望最终矩阵的权值尽可能小，你能帮小美求出这个最小权值吗？
 * 注：我们定义，上下左右四个方向相邻的相同字符是连通的。
 * <p>
 * 输入描述
 * 第一行输入一个正整数 n（1 <= n <= 10^4），代表字符串的长度。
 * 第二行输入一个长度为 n 的、仅由小写字母组成的字符串。
 * <p>
 * 输出描述
 * 输出一个整数表示最小权值。
 * <p>
 * 思路
 * dfs
 * <p>
 * 坑比较多，注意边界条件
 * 数据量上，直接开1e4的二维数组会MLE
 * 这题还有一个比较麻烦的点在于选取矩阵的m,n
 * 最早使用了n * n <= len判断循环
 * 导致另一半的情况未考虑
 * 即n=1, m=2 和n=2, m=1 不一定是同一种情况，
 * 由于g[i / n][i % n]是按序填入的，两者的权值可以不同
 */
public class Q131_小美的字符串变换 {
    private static final int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static char[][] g;
    private static boolean[][] vis;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        int ans = Integer.MAX_VALUE;
        for (int n = 2; n < len; n++) {
            if (len % n != 0) {
                continue;
            }
            int m = len / n;
            g = new char[m][n];
            vis = new boolean[m][n];
            for (int i = 0; i < len; i++) {
                g[i / n][i % n] = s.charAt(i);
            }
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (!vis[i][j]) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }
            ans = Math.min(ans, cnt);
        }
        System.out.println(ans);
    }

    private static void dfs(int x, int y) {
        vis[x][y] = true;
        for (int[] dir : dirs) {
            int nx = x + dir[0], ny = y + dir[1];
            if (nx < 0 || nx >= g.length || ny < 0 || ny >= g[0].length || vis[nx][ny] || g[x][y] != g[nx][ny]) {
                continue;
            }
            dfs(nx, ny);
        }
    }
}
