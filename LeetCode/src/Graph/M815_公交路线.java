package Graph;

import java.util.*;

/**
 * @author Hyperspace
 * @date 2024/09/17
 * @file M815_公交路线.java
 * <p>
 * 思路
 * bfs
 */
public class M815_公交路线 {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        int n = routes.length;
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j : routes[i]) {
                g.computeIfAbsent(j, k -> new ArrayList<>()).add(i);
            }
        }
        Map<Integer, Integer> d = new HashMap<>();
        Queue<Integer> q = new ArrayDeque<>();
        d.put(source, 0);
        q.offer(source);
        while (!q.isEmpty()) {
            int p = q.poll(), cur = d.get(p);
            for (int i : g.getOrDefault(p, new ArrayList<>())) {
                if (routes[i] != null) {
                    for (int j : routes[i]) {
                        if (!d.containsKey(j)) {
                            d.put(j, cur + 1);
                            q.add(j);
                        }
                    }
                    routes[i] = null;
                }
            }
        }

        return d.getOrDefault(target, -1);
    }
}
