package Graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Hyperspace
 * @date 2023/08/23
 * @file M1782_统计点对的数目.java
 * <p>
 * 思路
 * 题干嗯绕，花了一段时间理解cnt到输出的关系
 * 无向图带重复边，容斥原理参@pen999
 * 转化为deg(a) + deg(b) - deg(a, b) > queries[i]
 * 时间复杂度Cn2 = 2 * 10^4 * 10^4 = 2 * 10^8，直接求会超时
 * 而deg(a, b)，其数目不超过此无向图边的数目，即1*10^5
 * https://www.bilibili.com/video/BV1H54y1a7CC/?vd_source=7115cc0767117807176f824179ad7a7d
 * st(deg(a) + deg(b) - deg(a, b) > queries[i]) + st(deg(a) + deg(b) > queries[i] && deg(a, b) == 0)
 * = st(deg(a) + deg(b) - deg(a, b) > queries[i])
 * + (st(deg(a) + deg(b) > queries[i]) - st(deg(a) + deg(b) > queries[i] && deg(a, b) > 0)
 * = s1 + (s3 - s2)
 * 分类讨论：
 * 1) deg(a) + deg(b) - v > cnt且两个点之间有边
 * 2) deg(a) + deg(b) > cnt且ab间有边
 * 3) deg(a) + deg(b) > cnt 双指针找对应j时可配对的最小k，则[k, j]均满足
 * <p>
 * 待回看
 */
public class M1782_统计点对的数目 {
    final int N = 100000;

    public int[] countPairs(int n, int[][] edges, int[] queries) {
        int len = queries.length;
        int[] res = new int[len], deg = new int[n + 1];
        Map<Integer, Integer> mp = new HashMap<>();
        for (int[] e : edges) {
            int a = Math.min(e[0], e[1]), b = Math.max(e[0], e[1]);
            int u = a * N + b;
            deg[a]++;
            deg[b]++;
            mp.put(u, mp.getOrDefault(u, 0) + 1);
        }
        int[] ds = new int[n];
        System.arraycopy(deg, 1, ds, 0, n);
        Arrays.sort(ds);
        for (int i = 0; i < len; i++) {
            int st1 = 0, st2 = 0, st3 = 0;
            for (int k : mp.keySet()) {
                int a = k / N, b = k % N, v = mp.get(k);
                if (deg[a] + deg[b] - v > queries[i]) {
                    st1++;
                }
                if (deg[a] + deg[b] > queries[i]) {
                    st2++;
                }
            }
            for (int j = n - 1, k = 0; j > k; j--) {
                while (j > k && ds[k] + ds[j] <= queries[i]) {
                    k++;
                }
                if (j > k && ds[k] + ds[j] > queries[i]) {
                    st3 += j - k;
                }
            }
            res[i] = st1 + st3 - st2;
        }

        return res;
    }
}
