package Greedy;

/**
 * @author Hyper
 * @date 2024/07/19
 * @file M3096_得到更多分数的最少关卡数目.java
 * <p>
 * 思路
 * 1. 贪心+前缀和
 * 2. 前缀和空间优化
 */
public class M3096_得到更多分数的最少关卡数目 {
    public int minimumLevels(int[] possible) {
        int n = possible.length;
        int[] pre = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = (possible[i - 1] & 1) == 0 ? pre[i - 1] - 1 : pre[i - 1] + 1;
        }
        int ans = -1;
        for (int i = n - 1; i > 0; i--) {
            if (pre[i] > pre[n] - pre[i]) {
                ans = i;
            }
        }

        return ans;
    }

    public int minimumLevels2(int[] possible) {
        int n = possible.length;
        int pre = 0, cur = 0;
        for (int p : possible) {
            pre += (p & 1) == 0 ? -1 : 1;
        }
        for (int i = 1; i < n; i++) {
            cur += possible[i - 1] == 0 ? -1 : 1;
            if (cur > pre - cur) {
                return i;
            }
        }

        return -1;
    }
}
