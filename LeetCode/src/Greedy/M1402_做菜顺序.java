package Greedy;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2023/10/22
 * @file M1402_做菜顺序.java
 * <p>
 * 思路
 * 第一眼贪心，越大的数应该放在最后
 * 逆序遍历，从最大的数开始加
 * 之后每加一个数之前的数都会累加一次
 */
public class M1402_做菜顺序 {
    public int maxSatisfaction(int[] satisfaction) {
        int n = satisfaction.length;
        Arrays.sort(satisfaction);
        int ans = 0, sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum += satisfaction[i];
            if (sum < 0) {
                break;
            }
            ans += sum;
        }

        return ans;
    }
}
