package Array;

/**
 * @author Hyperspace
 * @date 2025/03/11
 * @file M2012_数组美丽值求和.java
 * <p>
 * 思路
 * 模拟
 * 前缀最大值+后缀最小值
 */
public class M2012_数组美丽值求和 {
    public int sumOfBeauties(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n + 1], suf = new int[n + 1];
        pre[0] = nums[0];
        suf[n] = nums[n - 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = Math.max(pre[i - 1], nums[i - 1]);
            suf[n - i] = Math.min(suf[n - i + 1], nums[n - i]);
        }
        int ans = 0;
        for (int i = 1; i < n - 1; i++) {
            if (pre[i] < nums[i] && nums[i] < suf[i + 1]) {
                ans += 2;
            } else if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) {
                ans++;
            }
        }

        return ans;
    }

    public int sumOfBeauties2(int[] nums) {
        int n = nums.length;
        int[] suf = new int[n + 1];
        suf[n] = nums[n - 1];
        for (int i = 1; i <= n; i++) {
            suf[n - i] = Math.min(suf[n - i + 1], nums[n - i]);
        }
        int ans = 0, preMax = nums[0];
        for (int i = 1; i < n - 1; i++) {
            int x = nums[i];
            if (preMax < x && x < suf[i + 1]) {
                ans += 2;
            } else if (nums[i - 1] < x && x < nums[i + 1]) {
                ans++;
            }
            preMax = Math.max(preMax, x);
        }

        return ans;
    }
}
