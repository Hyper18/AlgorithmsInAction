package Graph;

import java.util.TreeSet;

/**
 * @author Hyperspace
 * @date 2024/11/20
 * @file M3244_新增道路查询后的最短距离II.java
 * <p>
 * 思路@AustraliaShiyuan O((n+q)log(n))
 * 使用I的做法在n=100000时会TLE
 * 题干限定跳过的区间无交集，因此所有被跳过的城市都不可能再出现在最短路，直接删除
 */
public class M3244_新增道路查询后的最短距离II {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int m = queries.length;
        TreeSet<Integer> st = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            st.add(i);
        }
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            Integer l = st.higher(queries[i][0]), r = st.ceiling(queries[i][1]);
            st.subSet(l, r).clear();
            res[i] = st.size() - 1;
        }

        return res;
    }
}
