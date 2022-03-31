package Y2017A;

/**
 * @author Hyperspace
 * @date 2022/03/31
 * <p>
 * 标题：方格分割
 * <p>
 * 6x6的方格，沿着格子的边线剪开成两部分。
 * 要求这两部分的形状完全相同。
 * <p>
 * 如图：p1.png, p2.png, p3.png 就是可行的分割法。
 * <p>
 * 试计算：
 * 包括这3种分法在内，一共有多少种不同的分割方法。
 * 注意：旋转对称的属于同一种分割法。
 * <p>
 * 从中心N/2开始进行深搜
 */
public class Q4方格分割 {
    private static final int SIZE = 6;
    private static int[][] grid = new int[SIZE][SIZE];
    private static boolean[][] vis = new boolean[SIZE + 1][SIZE + 1];
    private static final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int ans;

    public static void main(String[] args) {
        int c = (SIZE + 1) / 2;
        vis[c][c] = true;
        dfs(c, c);
        System.out.println(ans / 4);
    }

    private static void dfs(int x, int y) {
        if (x <= 0 || x >= SIZE || y <= 0 || y >= SIZE) {
            ans++;
            return;
        }
        for (int[] d : dirs) {
            int nx = x + d[0];
            int ny = y + d[1];
            if (!vis[nx][ny]) {
                vis[nx][ny] = true;
                vis[SIZE - nx][SIZE - ny] = true;
                dfs(nx, ny);
                vis[SIZE - nx][SIZE - ny] = false;
                vis[nx][ny] = false;
            }
        }
    }
}
