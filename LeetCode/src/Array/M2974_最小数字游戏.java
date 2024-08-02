package Array;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Hyperspace
 * @date 2024/07/12
 * @file M2974_最小数字游戏.java
 * <p>
 * 思路
 * 1. 排序
 * 2. 小根堆
 */
public class M2974_最小数字游戏 {
    public int[] numberGame(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int t;
        for (int i = 0; i < n - 1; i += 2) {
            t = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = t;
        }

        return nums;
    }

    public int[] numberGame2(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int num : nums) {
            q.offer(num);
        }
        int i = 0;
        while (!q.isEmpty() && i < n) {
            res[i + 1] = q.poll();
            res[i] = q.poll();
            i += 2;
        }

        return res;
    }
}
