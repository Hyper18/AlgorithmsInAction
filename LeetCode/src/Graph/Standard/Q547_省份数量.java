package Graph.Standard;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Hyperspace
 * @date 2022/03/12
 * <p>
 * 思路
 * 考虑抽象转化为：
 * 该无向图中的连通分量的计数问题
 * 1. dfs
 * 2. bfs
 * 通过广搜入队，在每层进行计数
 */
public class Q547_省份数量 {
    private boolean[] visited;
    private int[][] isConnected;
    int n, ans = 0;

    public int findCircleNum(int[][] isConnected) {
        this.isConnected = isConnected;
        n = isConnected.length;
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
                ans++;
            }
        }

        return ans;
    }

    private void dfs(int i) {
        for (int j = 0; j < n; j++) {
            if (!visited[j] && isConnected[i][j] == 1) {
                visited[j] = true;
                dfs(j);
            }
        }
    }

    public int findCircleNum2(int[][] isConnected) {
        this.isConnected = isConnected;
        n = isConnected.length;
        visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    visited[node] = true;
                    for (int j = 0; j < n; j++) {
                        if (!visited[j] && isConnected[node][j] == 1) {
                            queue.offer(j);
                        }
                    }
                }
                ans++;
            }
        }

        return ans;
    }
}
