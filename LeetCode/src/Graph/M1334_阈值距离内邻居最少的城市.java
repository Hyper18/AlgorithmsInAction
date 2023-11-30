package Graph;

/**
 * @author Hyperspace
 * @date 2023/11/14
 * @file M1334_阈值距离内邻居最少的城市.java
 * <p>
 * 思路
 * DP，多源最短路
 * <p>
 * 注意多个距离最大时取编号最大者
 */
public class M1334_阈值距离内邻居最少的城市 {
    final int N = 105, INF = 0x3f3f3f3f;
    int[][] d = new int[N][N];
    int n;

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        this.n = n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                d[i][j] = i == j ? 0 : INF;
            }
        }
        for (int[] e : edges) {
            int a = e[0], b = e[1], c = e[2];
            d[a][b] = d[b][a] = Math.min(d[a][b], c);
        }
        floyd();
        int ans = -1, cnt = n + 10;
        for (int i = 0; i < n; i++) {
            int cur = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && d[i][j] <= distanceThreshold) {
                    cur++;
                }
            }
            if (cur <= cnt) {
                cnt = cur;
                ans = i;
            }
        }

        return ans;
    }

    private void floyd() {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                }
            }
        }
    }
}
