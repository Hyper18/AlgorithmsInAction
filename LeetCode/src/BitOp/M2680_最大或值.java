package BitOp;

/**
 * @author Hyper
 * @date 2025/03/21
 * @file M2680_最大或值.java
 * <p>
 * 思路
 * 1. 位运算
 * *2为全体左移1位
 * 2. 位运算优化
 * 使用类似的技巧，由于遍历的顺序时从前往后的
 * 因此前缀和只需要最新的状态，可以用一个long变量代替
 * <p>
 * 注意这里或运算不比异或，是不可逆的
 * 如 nums = [88,43,61,72,13], k = 6 时
 * 只开一个前缀和
 * 计算 (pre[n] - pre[i]) | (pre[i - 1] - pre[0])
 * 会输出5671而非5759
 */
public class M2680_最大或值 {
    public long maximumOr(int[] nums, int k) {
        int n = nums.length;
        long ans = 0;
        int[] pre = new int[n + 1], suf = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] | nums[i - 1];
            suf[n - i] = suf[n - i + 1] | nums[n - i];
        }
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, pre[i - 1] | suf[i] | ((long) nums[i - 1] << k));
        }

        return ans;
    }

    public long maximumOr2(int[] nums, int k) {
        int n = nums.length;
        int[] suf = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suf[i] = suf[i + 1] | nums[i];
        }
        long ans = 0, pre = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, pre | ((long) nums[i - 1] << k) | suf[i]);
            pre |= nums[i - 1];
        }

        return ans;
    }
}
