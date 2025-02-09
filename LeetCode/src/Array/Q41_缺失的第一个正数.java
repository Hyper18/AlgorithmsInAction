package Array;

import java.util.PriorityQueue;

/**
 * @author Hyper
 * @date 2025/02/09
 * @file Q41_缺失的第一个正数.java
 * <p>
 * 思路
 * 1. 模拟，小根堆 -- 使用O(n)空间
 * 2. 原地哈希@官解 -- 使用O(1)空间
 * 想半天没想到O(1)空间做法
 * 待回看
 */
public class Q41_缺失的第一个正数 {
    public int firstMissingPositive(int[] nums) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int num : nums) {
            if (num <= 0) {
                continue;
            }
            q.offer(num);
        }
        int ans = 1;
        while (!q.isEmpty()) {
            int p = q.poll();
            if (ans < p) {
                return ans;
            }
            ans = p + 1;
        }

        return ans;
    }

    public int firstMissingPositive2(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int t = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = t;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }
}
