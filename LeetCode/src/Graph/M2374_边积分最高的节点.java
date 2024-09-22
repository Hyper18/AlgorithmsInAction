package Graph;

/**
 * @author Hyperspace
 * @date 2024/09/21
 * @file M2374_边积分最高的节点.java
 * <p>
 * 思路
 * 统计有向图的入度
 * <p>
 * 注意爆int
 */
public class M2374_边积分最高的节点 {
    public int edgeScore(int[] edges) {
        int n = edges.length;
        long[] in = new long[n];
        for (int i = 0; i < n; i++) {
            in[edges[i]] += i;
        }
        int ans = -1;
        long mx = 0;
        for (int i = 0; i < n; i++) {
            if (in[i] > mx) {
                ans = i;
                mx = in[i];
            }
        }

        return ans;
    }
}
