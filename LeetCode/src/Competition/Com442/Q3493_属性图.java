package Competition.Com442;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Hyperspace
 * @date 2025/03/23
 * @file Q3493_属性图.java
 * <p>
 * 思路
 * 并查集+哈希
 */
public class Q3493_属性图 {
    class UnionFind {
        private int[] p;
        private int[] size;

        public UnionFind(int n) {
            p = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            if (p[x] != x) {
                p[x] = find(p[x]);
            }

            return p[x];
        }

        public boolean union(int a, int b) {
            int pa = find(a), pb = find(b);
            if (pa == pb) {
                return false;
            }
            if (size[pa] > size[pb]) {
                p[pb] = pa;
                size[pa] += size[pb];
            } else {
                p[pa] = pb;
                size[pb] += size[pa];
            }

            return true;
        }
    }

    public int numberOfComponents(int[][] properties, int k) {
        int n = properties.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (intersect(properties[i], properties[j]) >= k) {
                    uf.union(i, j);
                }
            }
        }
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < n; i++) {
            res.add(uf.find(i));
        }

        return res.size();
    }

    private int intersect(int[] a, int[] b) {
        Set<Integer> st = new HashSet<>();
        int ans = 0;
        for (int num : a) {
            st.add(num);
        }
        for (int num : b) {
            if (st.contains(num)) {
                ans++;
                st.remove(num);
            }
        }

        return ans;
    }
}
