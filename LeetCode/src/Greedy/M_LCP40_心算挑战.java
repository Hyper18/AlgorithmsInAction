package Greedy;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2024/08/01
 * @file M_LCP40_心算挑战.java
 * <p>
 * 思路
 * 排序+贪心
 * 核心是优先把最大的都加到sum
 * 注意讨论sum为奇数时：
 * 1) 去掉最小的一个偶数，找剩余中最大的奇数
 * 2) 去掉最小的一个奇数，找剩余中最大的偶数
 * 上述两种情况均可满足sum为偶数，容易漏掉2
 */
public class M_LCP40_心算挑战 {
    public int maxmiumScore(int[] cards, int cnt) {
        int n = cards.length;
        Arrays.sort(cards);
        int ans = 0, i, mn1 = Integer.MAX_VALUE, mn2 = Integer.MAX_VALUE;
        for (i = n - 1; cnt > 0; i--, cnt--) {
            ans += cards[i];
            if (cards[i] % 2 != 0) {
                mn1 = Math.min(mn1, cards[i]);
            } else {
                mn2 = Math.min(mn2, cards[i]);
            }
        }
        if (ans % 2 == 0) {
            return ans;
        }
        while (i >= 0) {
            if ((ans - mn1 + cards[i]) % 2 == 0) {
                return ans - mn1 + cards[i];
            }
            if ((ans - mn2 + cards[i]) % 2 == 0) {
                return ans - mn2 + cards[i];
            }
            i--;
        }

        return 0;
    }
}
