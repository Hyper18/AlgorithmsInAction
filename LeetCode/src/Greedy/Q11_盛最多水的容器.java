package Greedy;

/**
 * @author Hyper
 * @date 2025/02/06
 * @file Q11_盛最多水的容器.java
 * <p>
 * 思路
 * 1. 贪心 两侧往里双指针 -- O(n)
 * 2. 优化 1ms
 */
public class Q11_盛最多水的容器 {
    public int maxArea(int[] height) {
        int n = height.length;
        int ans = 0, l = 0, r = n - 1;
        while (l < r) {
            ans = Math.max(ans, (r - l) * Math.min(height[l], height[r]));
            if (height[l] >= height[r]) {
                r--;
            } else {
                l++;
            }
        }

        return ans;
    }

    public int maxArea2(int[] height) {
        int n = height.length;
        int ans = 0, l = 0, r = n - 1;
        while (l < r) {
            int lh = height[l], rh = height[r];
            ans = Math.max(ans, (r - l) * Math.min(lh, rh));
            if (lh >= rh) {
                while (l < r && height[r] <= rh) {
                    r--;
                }
            } else {
                while (l < r && lh >= height[l]) {
                    l++;
                }
            }
        }

        return ans;
    }
}
