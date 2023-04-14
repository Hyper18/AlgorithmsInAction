package Array;

/**
 * @author Hyperspace
 * @date 2023/02/28
 * @file Q1004_最大连续1的个数III.java
 * 思路
 * 1. SWM
 * 2. SWM简化
 * 3. 前缀和 + 二分
 */
public class Q1004_最大连续1的个数III {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int ans = 0, cnt = 0, l = 0, r = 0;
        while (r < n) {
            if (nums[r] == 0) {
                cnt++;
            }
            r++;
            while (cnt > k) {
                if (nums[l] == 0) {
                    cnt--;
                }
                l++;
            }
            ans = Math.max(ans, r - l);
        }

        return ans;
    }

    public int longestOnes2(int[] nums, int k) {
        int n = nums.length;
        int cnt = 0, l = 0, r = 0;
        while (r < n) {
            if (nums[r] == 0) {
                cnt++;
            }
            r++;
            if (cnt > k) {
                if (nums[l] == 0) {
                    cnt--;
                }
                l++;
            }
        }

        return r - l;
    }

    public int longestOnes3(int[] nums, int k) {
        int n = nums.length;
        int[] pre = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + nums[i - 1];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int low = 0, high = i;
            while (low < high) {
                int mid = low + ((high - low) >> 1);
                if (check(pre, mid, i, k)) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            if (check(pre, high, i, k)) {
                ans = Math.max(ans, i - high + 1);
            }
        }

        return ans;
    }

    boolean check(int[] pre, int l, int r, int k) {
        int tot = pre[r + 1] - pre[l], cnt = r - l + 1;
        return cnt - tot <= k;
    }
}
