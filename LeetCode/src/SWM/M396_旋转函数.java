package SWM;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2022/04/22
 * 思路
 * 1. 纯模拟（超时） -- O(n^2)
 * 2. svm + 前缀和 -- O(n)
 * 3. 优化的模拟 -- O(n)
 * 核心思路是
 * 比较两个相邻的要计算的值
 * 看这两个值的差 F(i)-F(i-1)
 * 这样就能从 F(0) 出发，O(1) 地计算出下一个 F 值。
 */
public class M396_旋转函数 {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += j < i ? j * nums[n - 1 - i + j] : j * nums[j - i];
            }
            ans = Math.max(ans, sum);
        }

        return ans;
    }

    public int maxRotateFunction2(int[] nums) {
        int n = nums.length;
        int[] sum = new int[2 * n + 10];
        for (int i = 1; i <= 2 * n; i++) {
            sum[i] = sum[i - 1] + nums[(i - 1) % n];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += i * nums[i];
        }
        for (int i = n + 1, cur = ans; i < 2 * n; i++) {
            cur = cur + nums[(i - 1) % n] * (n - 1) - sum[i - 1];
            cur -= sum[i - n];
            ans = Math.max(ans, cur);
        }

        return ans;
    }

    public int maxRotateFunction3(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += i * nums[i];
        }
        int sum = Arrays.stream(nums).sum();
        for (int i = n - 1, cur = ans; i >= 0; i--) {
            cur += sum - n * nums[i];
            ans = Math.max(ans, cur);
        }

        return ans;
    }
}
