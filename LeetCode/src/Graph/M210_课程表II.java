package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Hyper
 * @date 2023/09/10
 * @file M210_课程表II.java
 * <p>
 * 思路
 * 在Q207基础上
 * 收集单向路径
 */
public class M210_课程表II {
    final int N = 4000000;
    int[] h = new int[N], e = new int[N], ne = new int[N];
    int[] d = new int[N], q = new int[N];
    List<Integer> li = new LinkedList<>();
    int n, m, idx;

    private void addEdge(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        n = numCourses;
        m = prerequisites.length;
        Arrays.fill(h, -1);
        for (int[] p : prerequisites) {
            int cur = p[0], pre = p[1];
            addEdge(pre, cur);
            d[cur]++;
        }
        if (topSort()) {
            return li.stream().mapToInt(Integer::intValue).toArray();
        }

        return new int[]{};
    }

    private boolean topSort() {
        int hh = 0, tt = -1;
        for (int i = 0; i < n; i++) {
            if (d[i] == 0) {
                q[++tt] = i;
            }
        }

        while (hh <= tt) {
            int u = q[hh++];
            li.add(u);
            for (int i = h[u]; i != -1; i = ne[i]) {
                int j = e[i];
                if (--d[j] == 0) {
                    q[++tt] = j;
                }
            }
        }

        return tt == n - 1;
    }
}
