package DisjointSet;

/**
 * @author Hyperspace
 * @date 2025/06/05
 * @file M1061_按字典序排列最小的等效字符串.java
 * <p>
 * 思路
 * 并查集裸
 */
public class M1061_按字典序排列最小的等效字符串 {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int n = s1.length();
        UnionFind uf = new UnionFind(26);
        for (int i = 0; i < n; i++) {
            uf.union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }
        StringBuilder sb = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            sb.append((char) (uf.find(c - 'a') + 'a'));
        }

        return sb.toString();
    }

    class UnionFind {
        private int[] p;

        public UnionFind(int n) {
            p = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = i;
            }
        }

        public int find(int x) {
            if (p[x] != x) {
                p[x] = find(p[x]);
            }
            return p[x];
        }

        public void union(int a, int b) {
            int pa = find(a), pb = find(b);
            if (pa == pb) {
                return;
            }
            if (pa < pb) {
                p[pb] = pa;
            } else {
                p[pa] = pb;
            }
        }
    }
}
