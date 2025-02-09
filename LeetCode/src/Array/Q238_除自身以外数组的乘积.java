package Array;

/**
 * @author Hyper
 * @date 2025/02/09
 * @file Q238_除自身以外数组的乘积.java
 * <p>
 * 思路
 * 前缀积+后缀积
 * 很自然的想法是算出所有数之积并依次除以每个元素的值
 * 而本题本质是考察如何在使用除法的情况下排除自身的值
 * 故利用类似前缀和的思想
 * 遍历得到每个数左侧所有值的积*右侧所有值的积
 */
public class Q238_除自身以外数组的乘积 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n + 1], suf = new int[n + 1];
        pre[0] = suf[0] = 1;
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
            suf[i] = suf[i - 1] * nums[n - i];
        }
        for (int i = 0; i < n; i++) {
            nums[i] = pre[i] * suf[n - 1 - i];
        }

        return nums;
    }
}
