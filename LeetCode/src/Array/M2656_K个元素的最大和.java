package Array;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2023/11/15
 * @file M2656_K个元素的最大和.java
 * <p>
 * 思路
 * 模拟，等差数列
 */
public class M2656_K个元素的最大和 {
    public int maximizeSum(int[] nums, int k) {
        int max = Arrays.stream(nums).max().getAsInt();
        int ans = 0;
        while (k-- > 0) {
            ans += max++;
        }

        return ans;
    }

    public int maximizeSum2(int[] nums, int k) {
        int max = Arrays.stream(nums).max().getAsInt();
        return k * (max + (max + k - 1)) / 2;
    }

    public int maximizeSum3(int[] nums, int k) {
        return k * Arrays.stream(nums).max().getAsInt() + k * (k - 1) / 2;
    }
}
