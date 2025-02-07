package Array;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2023/07/23，2025/02/06
 * @file M42_接雨水.java
 * <p>
 * 思路
 * 模拟，经典题
 * 1. 按行求
 * 2. 按列求 遍历
 * 3. 按列求 DP 参考@windliang
 * f[i]、g[i]表示第i列左侧和右侧最高列的高度
 * 4. 按列求 双指针，进一步优化空间复杂度
 * 5. 按列求 相向双指针+贪心
 */
public class M42_接雨水 {
    public int trap(int[] height) {
        int maxH = Arrays.stream(height).max().getAsInt();
        int ans = 0;
        for (int i = 1; i <= maxH; i++) {
            boolean f = false;
            int cur = 0;
            for (int h : height) {
                if (f && h < i) {
                    cur++;
                }
                if (h >= i) {
                    ans += cur;
                    f = true;
                    cur = 0;
                }
            }
        }

        return ans;
    }

    public int trap2(int[] height) {
        int n = height.length;
        int ans = 0;
        for (int i = 1; i < n - 1; i++) {
            int hl = 0, hr = 0;
            for (int j = i - 1; j >= 0; j--) {
                hl = Math.max(hl, height[j]);
            }
            for (int j = i + 1; j < n; j++) {
                hr = Math.max(hr, height[j]);
            }
            int h = Math.min(hl, hr);
            if (h > height[i]) {
                ans += h - height[i];
            }
        }

        return ans;
    }

    public int trap3(int[] height) {
        int n = height.length;
        int[] f = new int[n], g = new int[n];
        int ans = 0;
        for (int i = 1; i < n - 1; i++) {
            f[i] = Math.max(f[i - 1], height[i - 1]);
            g[n - 1 - i] = Math.max(g[n - i], height[n - i]);
        }
        for (int i = 1; i < n - 1; i++) {
            int h = Math.min(f[i], g[i]);
            if (h > height[i]) {
                ans += h - height[i];
            }
        }

        return ans;
    }

    public int trap4_0(int[] height) {
        int n = height.length;
        int[] g = new int[n];
        int ans = 0, hl = 0;
        for (int i = 1; i < n - 1; i++) {
            g[n - 1 - i] = Math.max(g[n - i], height[n - i]);
        }
        for (int i = 1; i < n - 1; i++) {
            hl = Math.max(hl, height[i - 1]);
            int h = Math.min(hl, g[i]);
            if (h > height[i]) {
                ans += h - height[i];
            }
        }

        return ans;
    }

    public int trap4_1(int[] height) {
        int n = height.length;
        int[] g = new int[n];
        int ans = 0, hl = 0;
        for (int i = n - 2; i >= 0; i--) {
            g[i] = Math.max(g[i + 1], height[i + 1]);
        }
        for (int i = 1; i < n - 1; i++) {
            hl = Math.max(hl, height[i - 1]);
            int h = Math.min(hl, g[i]);
            if (h > height[i]) {
                ans += h - height[i];
            }
        }

        return ans;
    }

    public int trap4_2(int[] height) {
        int n = height.length;
        int i = 1, ans = 0, hl = 0, hr = 0, l = 1, r = n - 2;
        while (i < n - 1) {
            if (height[l - 1] < height[r + 1]) {
                hl = Math.max(hl, height[l - 1]);
                if (hl > height[l]) {
                    ans += hl - height[l];
                }
                l++;
            } else {
                hr = Math.max(hr, height[r + 1]);
                if (hr > height[r]) {
                    ans += hr - height[r];
                }
                r--;
            }
            i++;
        }

        return ans;
    }

    public int trap5_0(int[] height) {
        int n = height.length;
        int ans = 0, l = 0, r = n - 1;
        while (l < r) {
            int lh = height[l], rh = height[r];
            if (lh <= rh) {
                while (l < r && height[l] <= lh) {
                    l++;
                    if (lh > height[l]) {
                        ans += lh - height[l];
                    }
                }
            } else {
                while (l < r && height[r] <= rh) {
                    r--;
                    if (rh > height[r]) {
                        ans += rh - height[r];
                    }
                }
            }
        }

        return ans;
    }

    public int trap5_1(int[] height) {
        int n = height.length;
        int ans = 0, l = 0, r = n - 1, lh = 0, rh = 0;
        while (l < r) {
            lh = Math.max(lh, height[l]);
            rh = Math.max(rh, height[r]);
            ans += lh <= rh ? lh - height[l++] : rh - height[r--];
        }

        return ans;
    }
}
