package DisjointSet;

/**
 * @author Hyperspace
 * @date 2022/03/12
 * 并查集解法
 * 对相连的城市进行合并，
 * 从而得到该无向图中连通分量的个数
 */
public class Q547_省份数量 {
    private int[] parent;
    int n;

    public int findCircleNum(int[][] isConnected) {
        n = isConnected.length;
        init();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                ans++;
            }
        }

        return ans;
    }

    private void init() {
        parent = new int[n];
        for (int i = 1; i < n; i++) {
            parent[i] = i;
        }
    }

    private int find(int idx) {
        if (parent[idx] != idx) {
            parent[idx] = find(parent[idx]);
        }
        return parent[idx];
    }

    private void union(int idx1, int idx2) {
        parent[find(idx1)] = find(idx2);
    }
}
