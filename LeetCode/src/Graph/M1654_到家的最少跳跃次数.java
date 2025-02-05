package Graph;

import java.util.*;

/**
 * @author Hyper
 * @date 2023/08/30
 * @file M1654_到家的最少跳跃次数.java
 * <p>
 * 思路
 * 最短路
 */
public class M1654_到家的最少跳跃次数 {
    final int N = 6010, INF = 0x3f3f3f3f, FORWARD = 0, BACKWARD = 1;
    int[] d = new int[N];
    boolean[] vis = new boolean[N];

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Set<Integer> set = new HashSet<>();
        for (int f : forbidden) {
            set.add(f);
        }
        spfa(set, x, a, b);

        return d[x] == INF ? -1 : d[x];
    }

    public void spfa(Set<Integer> set, int x, int a, int b) {
        Arrays.fill(d, INF);
        d[0] = 0;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, FORWARD});
        vis[0] = true;
        while (!q.isEmpty()) {
            int[] u = q.poll();
            int i = u[0], st = u[1];
            if (i == x) {
                return;
            }
            int j = i + a;
            if (j < N && !set.contains(j) && !vis[j]) {
                if (d[i] + 1 < d[j]) {
                    d[j] = d[i] + 1;
                }
                vis[j] = true;
                q.offer(new int[]{j, FORWARD});
            }
            j = i - b;
            if (st == FORWARD && j >= 0 && !set.contains(j) && !vis[j]) {
                if (d[i] + 1 < d[j]) {
                    d[j] = d[i] + 1;
                }
                q.offer(new int[]{j, BACKWARD});
            }
        }
    }
}
