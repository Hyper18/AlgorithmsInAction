package Graph;

/**
 * @author Hyperspace
 * @date 2023/08/31
 * @file M1761_一个图中连通三元组的最小度数.java
 * <p>
 * 思路
 * 模拟
 */
public class M1761_一个图中连通三元组的最小度数 {
    final int N = 405, INF = 0x3f3f3f3f;
    boolean[][] f = new boolean[N][N];
    int[] d = new int[N];

    public int minTrioDegree(int n, int[][] edges) {
        for (int[] e : edges) {
            f[e[0]][e[1]] = f[e[1]][e[0]] = true;
            d[e[0]]++;
            d[e[1]]++;
        }
        int ans = INF;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                for (int k = j + 1; k <= n; k++) {
                    if (f[i][j] && f[j][k] && f[k][i]) {
                        ans = Math.min(ans, d[i] + d[j] + d[k] - 6);
                    }
                }
            }
        }

        return ans == INF ? -1 : ans;
    }
}
