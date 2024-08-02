package Graph;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2024/07/17
 * @file M2959_关闭分部的可行集合数目.java
 * <p>
 * 思路
 * dfs+最短路
 * 首先注意到题目卡n=10
 * 小数据量直接邻接矩阵建图
 * 二进制枚举每个节点的最短路，与maxDistance比较
 * <p>
 * 注意验证连通关系
 * <p>
 * 待回看，学习了一个tag的小trick
 */
public class M2959_关闭分部的可行集合数目 {
    private final int N = 11, INF = 0x3f3f3f3f;
    int[][] g = new int[N][N], d = new int[N][N];
    int ans;

    public int numberOfSets(int n, int maxDistance, int[][] roads) {
        // create graph
        for (int[] row : g) {
            Arrays.fill(row, INF);
        }
        for (int[] e : roads) {
            int a = e[0], b = e[1], c = e[2];
            g[a][b] = Math.min(g[a][b], c);
            g[b][a] = Math.min(g[b][a], c);
        }
        next:
        for (int st = 0; st < (1 << n); st++) {
            for (int i = 0; i < n; i++) {
                if ((st >> i & 1) == 1) {
                    System.arraycopy(g[i], 0, d[i], 0, n);
                }
            }
            // floyd
            for (int k = 0; k < n; k++) {
                if ((st >> k & 1) == 0) {
                    continue;
                }
                for (int i = 0; i < n; i++) {
                    if ((st >> i & 1) == 0) {
                        continue;
                    }
                    for (int j = 0; j < n; j++) {
                        d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                    }
                }
            }
            // validate
            for (int i = 0; i < n; i++) {
                if ((st >> i & 1) == 0) {
                    continue;
                }
                for (int j = 0; j < i; j++) {
                    // connected && smaller than maxDistance?
                    if ((st >> j & 1) == 1 && d[i][j] > maxDistance) {
                        continue next;
                    }
                }
            }
            ans++;
        }

        return ans;
    }
}
