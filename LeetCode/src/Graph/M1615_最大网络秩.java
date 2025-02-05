package Graph;

/**
 * @author Hyper
 * @date 2023/03/15
 * @file M1615_最大网络秩.java
 * <p>
 * 思路
 * 模拟，用一个二维数组标记两城市之间的连接状况
 * 遍历，对连接的结果-1，取最大值作为结果
 */
public class M1615_最大网络秩 {
    public int maximalNetworkRank(int n, int[][] roads) {
        boolean[][] isConnected = new boolean[n][n];
        int[] degree = new int[n];
        for (int[] v : roads) {
            isConnected[v[0]][v[1]] = true;
            isConnected[v[1]][v[0]] = true;
            degree[v[0]]++;
            degree[v[1]]++;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int cnt = degree[i] + degree[j] - (isConnected[i][j] ? 1 : 0);
                ans = Math.max(ans, cnt);
            }
        }

        return ans;
    }
}
