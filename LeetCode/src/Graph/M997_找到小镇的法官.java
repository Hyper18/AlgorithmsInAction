package Graph;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hyper
 * @date 2024/09/22
 * @file M997_找到小镇的法官.java
 * <p>
 * 思路
 * 1. 模拟
 * 限制条件：
 * 1) 法官本人不能信任他人 ans != trust[i][0]
 * 2) 每个人都信任法官 trust[i][1] == ans && cnt(ans) == n - 1
 * 3) 只有一个法官
 * 2. 统计有向图的入度/出度
 */
public class M997_找到小镇的法官 {
    public int findJudge(int n, int[][] trust) {
        if (n == 1) {
            return n;
        }
        if (trust.length == 0) {
            return -1;
        }
        Map<Integer, Integer> mp = new HashMap<>();
        for (int[] t : trust) {
            mp.put(t[1], mp.getOrDefault(t[1], 0) + 1);
        }
        int cnt = n - 1, ans = -1;
        for (Map.Entry<Integer, Integer> e : mp.entrySet()) {
            if (e.getValue() >= cnt) {
                cnt = e.getValue();
                ans = e.getKey();
            }
        }
        for (int[] t : trust) {
            if (t[0] == ans) {
                return -1;
            }
        }

        return ans;
    }

    public int findJudge2(int n, int[][] trust) {
        int[] in = new int[n + 1], out = new int[n + 1];
        for (int[] e : trust) {
            in[e[1]]++;
            out[e[0]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (in[i] == n - 1 && out[i] == 0) {
                return i;
            }
        }

        return -1;
    }
}
