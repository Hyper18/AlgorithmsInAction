package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hyperspace
 * @date 2023/05/01
 * @file M1376_通知所有员工所需的时间.java
 * <p>
 * 思路
 * dfs
 */
public class M1376_通知所有员工所需的时间 {
    private int ans = 0;

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<Integer> g[] = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 0; i < n; i++) {
            if (manager[i] > -1) {
                g[manager[i]].add(i);
            }
        }
        dfs(g, informTime, headID, 0);

        return ans;
    }

    private void dfs(List<Integer>[] g, int[] informTime, int cur, int sum) {
        sum += informTime[cur];
        ans = Math.max(ans, sum);
        for (int e : g[cur]) {
            dfs(g, informTime, e, sum);
        }
    }
}
