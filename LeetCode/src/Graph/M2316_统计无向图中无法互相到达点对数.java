package Graph;

import java.util.*;

/**
 * @author Hyper
 * @date 2023/10/21
 * @file M2316_统计无向图中无法互相到达点对数.java
 * <p>
 * 思路
 * bfs
 * 假设共有n个结点，存在一个连通块，包含cnt个节点
 * 那么这部分节点到其他连通块内的所有节点n - cnt均不可达
 * 这样的点对数目 = cnt * (n - cnt)对
 * 遍历并累加结果，并将最终结果除以2（无向图）去重
 * <p>
 * 注：注意不要溢出，以及Arrays.setAll()的使用
 * p.s. 没有vector确实用的不爽。。
 */
public class M2316_统计无向图中无法互相到达点对数 {
    public static long countPairs(int n, int[][] edges) {
        List<Integer>[] g = new ArrayList[n];
        // Arrays.fill(g, new ArrayList<>()); // 不要用于对象赋值，会为每个g[i]引用相同的ArrayList
        Arrays.setAll(g, e -> new ArrayList<>());
        boolean[] vis = new boolean[n];
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (vis[i]) {
                continue;
            }
            long cnt = 0;
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            vis[i] = true;
            while (!q.isEmpty()) {
                int p = q.poll();
                cnt++;
                for (int ne : g[p]) {
                    if (!vis[ne]) {
                        vis[ne] = true;
                        q.offer(ne);
                    }
                }
            }
            ans += cnt * (n - cnt);
        }

        return ans >> 1;
    }
}
