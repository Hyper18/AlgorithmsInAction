package SWM;

/**
 * @author Hyperspace
 * @date 2024/11/27
 * @file M3208_交替组II.java
 * <p>
 * 思路
 * 1. 拼接数组，双指针模拟 TLE
 * 2. SWM
 * 3. SWM优化
 * (1) 对于成环数组的处理，取余
 * (2) 对于条件的比较只需比较左侧元素，即colors[r] != colors[r + 1]可省
 * (3) >= k 无需处理窗口的左端点，因为只要(2)满足，则总是满足交替
 * (4) colors[(i + n) % n] == colors[(i - 1 + n) % n]中 +n 的可省
 */
public class M3208_交替组II {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length, m = n << 1;
        int[] nums = new int[m];
        System.arraycopy(colors, 0, nums, 0, n);
        System.arraycopy(colors, 0, nums, n, n);
        int ans = 0, cnt = 0, l = 0, r = 1;
        while (l < n) {
            while (r < m - 1 && cnt < k - 2 && nums[r] != nums[r - 1] && nums[r] != nums[r + 1]) {
                cnt++;
                r++;
            }
            if (cnt == k - 2) {
                ans++;
            }
            l++;
            r = l + 1;
            cnt = 0;
        }

        return ans;
    }

    public int numberOfAlternatingGroups2(int[] colors, int k) {
        int n = colors.length, m = n << 1;
        int[] nums = new int[m];
        System.arraycopy(colors, 0, nums, 0, n);
        System.arraycopy(colors, 0, nums, n, n);
        int ans = 0, cnt = 0, l = 0, r = 1;
        while (l < n) {
            while (r < m - 1 && cnt < k - 2 && nums[r] != nums[r - 1] && nums[r] != nums[r + 1]) {
                cnt++;
                r++;
            }
            if (cnt == k - 2) {
                ans++;
                cnt--;
                l++;
            } else {
                while (l < r) {
                    if (nums[l + 1] != nums[l] && nums[l + 2] != nums[l + 1]) {
                        cnt--;
                    }
                    l++;
                }
                r = l + 1;
            }
        }

        return ans;
    }

    public int numberOfAlternatingGroups3(int[] colors, int k) {
        int n = colors.length;
        int ans = 0, cnt = 1;
        for (int i = 1; i < n + k - 1; i++) {
            if (colors[i % n] != colors[(i - 1) % n]) {
                if (++cnt >= k) {
                    ans++;
                }
            } else {
                cnt = 1;
            }
        }

        return ans;
    }
}
