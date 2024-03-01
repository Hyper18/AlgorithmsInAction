package Greedy;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2024/02/02
 * @file M1686_石子游戏VI.java
 * <p>
 * 思路
 * 排序，贪心
 * 先手的A优先拿走：
 * 对自己来说当前最大的数
 * 对对手来说当前最大的数
 * 即aliceValues[i] + bobValues[i]
 * <p>
 * 创建一个下标数组排序，按照当前规律降序排序
 * A和B交替拿
 */
public class M1686_石子游戏VI {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (i, j) -> aliceValues[j] + bobValues[j] - aliceValues[i] - bobValues[i]);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += i % 2 == 0 ? aliceValues[idx[i]] : -bobValues[idx[i]];
        }

        return Integer.compare(ans, 0);
    }
}
