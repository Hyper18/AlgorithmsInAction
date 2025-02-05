package Tree;

import java.util.*;

/**
 * @author Hyper
 * @date 2023/09/21
 * @file M2603_收集树中金币.java
 * <p>
 * 思路
 * 拓扑排序，参@灵茶山艾府
 * 1. 先去除没有金币的叶子结点
 * 2. 再移动到叶子节点的父节点的父节点，收集金币
 * 3. 路径经过每条边两次，结果为剩余边*2
 */
public class M2603_收集树中金币 {
    public int collectTheCoins(int[] coins, int[][] edges) {
        int n = coins.length;
        List<Integer> g[] = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        int[] d = new int[n];
        for (int[] e : edges) {
            int a = e[0], b = e[1];
            g[a].add(b);
            g[b].add(a);
            d[a]++;
            d[b]++;
        }
        int leftEdges = n - 1;
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (d[i] == 1 && coins[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            leftEdges--;
            for (int j : g[q.poll()]) {
                if (--d[j] == 1 && coins[j] == 0) {
                    q.add(j);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (d[i] == 1 && coins[i] == 1) {
                q.add(i);
            }
        }
        leftEdges -= q.size();
        for (int a : q) {
            for (int b : g[a]) {
                if (--d[b] == 1) {
                    leftEdges--;
                }
            }
        }

        return Math.max(leftEdges * 2, 0);
    }
}
