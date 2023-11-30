package Graph;

import java.util.*;

/**
 * @author Hyperspace
 * @date 2023/11/01
 * @file M2127_参加会议的最多员工数.java
 * <p>
 * 思路
 * 连着两天hard。。
 * 内向基环树 (pseudotree)：
 * 每一个内向基环树（连通块）都由一个基环和其余指向基环的树枝组成
 * 由于基环上的节点的入度均为1，拓扑排序剪枝
 * 树枝节点的入度均为0
 * 分类讨论：
 * 1) 基环长度大于2
 * 依次遍历基环，取基环长度的最大值
 * 2) 基环长度等于2
 * 从基环与树枝节点的连接点出发，在反图上溯源最大树枝节点深度
 */
public class M2127_参加会议的最多员工数 {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        int[] deg = new int[n];
        for (int f : favorite) {
            deg[f]++;
        }
        List<Integer>[] rg = new ArrayList[n];
        Arrays.setAll(rg, e -> new ArrayList<>());
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (deg[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int a = q.poll(), b = favorite[a];
            rg[b].add(a);
            if (--deg[b] == 0) {
                q.add(b);
            }
        }

        int maxRingSize = 0, sumChainSize = 0;
        for (int i = 0; i < n; i++) {
            if (deg[i] == 0) {
                continue;
            }
            deg[i] = 0;
            int ringSize = 1;
            for (int j = favorite[i]; j != i; j = favorite[j]) {
                deg[j] = 0;
                ringSize++;
            }
            if (ringSize == 2) {
                sumChainSize += rdfs(i, rg) + rdfs(favorite[i], rg);
            } else {
                maxRingSize = Math.max(maxRingSize, ringSize);
            }
        }

        return Math.max(maxRingSize, sumChainSize);
    }

    private int rdfs(int x, List<Integer>[] rg) {
        int maxDepth = 1;
        for (int child : rg[x]) {
            maxDepth = Math.max(maxDepth, rdfs(child, rg) + 1);
        }

        return maxDepth;
    }

    public int maximumInvitations2(int[] favorite) {
        int n = favorite.length;
        int[] deg = new int[n];
        for (int f : favorite) {
            deg[f]++;
        }
        int[] maxDepth = new int[n];
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (deg[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int a = q.poll(), b = favorite[a];
            maxDepth[b] = maxDepth[a] + 1;
            if (--deg[b] == 0) {
                q.offer(b);
            }
        }
        int maxRingSize = 0, sumChainSize = 0;
        for (int i = 0; i < n; i++) {
            if (deg[i] == 0) {
                continue;
            }
            deg[i] = 0;
            int ringSize = 1;
            for (int j = favorite[i]; j != i; j = favorite[j]) {
                deg[j] = 0;
                ringSize++;
            }
            if (ringSize == 2) {
                sumChainSize += maxDepth[i] + maxDepth[favorite[i]] + 2;
            } else {
                maxRingSize = Math.max(maxRingSize, ringSize);
            }
        }

        return Math.max(maxRingSize, sumChainSize);
    }
}
