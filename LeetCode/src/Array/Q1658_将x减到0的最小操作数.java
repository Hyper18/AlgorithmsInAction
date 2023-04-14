package Array;

/**
 * @author Hyperspace
 * @date 2023/03/05
 * @file Q1658_将x减到0的最小操作数.java
 * <p>
 * 思路
 * 前缀和+二分
 * 对原数组求前缀和
 * 从后向前遍历，第一次不取右侧，第二次取数组的最后一个元素num，以此类推
 * 此时二分查找x-0，x-num ……在前缀中下标的位置，并记录
 * 依次操作，直到找到可行的最小长度
 * <p>
 * 注意二分的上下边界
 */
public class Q1658_将x减到0的最小操作数 {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        if (nums[0] > x && nums[n - 1] > x) {
            return -1;
        }
        int[] pre = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + nums[i - 1];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0 && x >= 0; x -= nums[i--]) {
            int l = -1, r = n - 1 - i, low = 0, high = i + 1;
            while (low <= high) {
                int mid = low + ((high - low) >> 1);
                if (pre[mid] == x) {
                    l = mid;
                    break;
                } else if (pre[mid] > x) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            if (l >= 0) {
                ans = Math.min(ans, l + r);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
