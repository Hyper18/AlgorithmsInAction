package Graph;

import java.util.*;

/**
 * @author Hyper
 * @date 2023/07/28
 * @file M2050_并行课程III.java
 * <p>
 * 思路
 * 有向无环图，拓扑排序
 * d[i]表示入度
 * f[i]表示完成第i门节点处课程所需时间
 */
public class M2050_并行课程III {
    public int minimumTime(int n, int[][] relations, int[] time) {
        int[] d = new int[n + 1], f = new int[n + 1];
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            g.add(new ArrayList<>());
        }
        for (int[] r : relations) {
            g.get(r[0]).add(r[1]);
            d[r[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (d[i] == 0) {
                q.add(i);
                f[i] = time[i - 1];
            }
        }
        while (!q.isEmpty()) {
            int t = q.poll();
            for (int v : g.get(t)) {
                f[v] = Math.max(f[v], f[t] + time[v - 1]);
                if (--d[v] == 0) {
                    q.add(v);
                }
            }
        }

        return Arrays.stream(f).max().getAsInt();
    }

    public int minimumTime2(int n, int[][] relations, int[] time) {
        int[] d = new int[n + 1], f = new int[n + 1];
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            g.add(new ArrayList<>());
        }
        for (int[] r : relations) {
            g.get(r[0]).add(r[1]);
            d[r[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (d[i] == 0) {
                q.add(i);
            }
        }
        int ans = 0;
        while (!q.isEmpty()) {
            int t = q.poll();
            f[t] += time[t - 1];
            ans = Math.max(ans, f[t]);
            for (int v : g.get(t)) {
                f[v] = Math.max(f[v], f[t]);
                if (--d[v] == 0) {
                    q.add(v);
                }
            }
        }

        return ans;
    }
}
