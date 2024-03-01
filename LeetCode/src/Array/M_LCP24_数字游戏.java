package Array;

import java.util.PriorityQueue;

/**
 * @author Hyperspace
 * @date 2024/02/01
 * @file M_LCP24_数字游戏.java
 * <p>
 * 思路
 * 1. 普通的贪心
 * 2. 对中位数的贪心，对顶堆
 */
public class M_LCP24_数字游戏 {
    final int MOD = (int) 1e9 + 7;

    public int[] numsGame_0(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 1; i < n; i++) {
            int t = nums[i] - nums[i - 1];
            if (t == 1) {
                res[i] = res[i - 1];
            } else {
                res[i] = t >= 0 ? (res[i - 1] + t - 1) % MOD : (res[i - 1] - t + 1) % MOD;
                nums[i] = nums[i - 1] + 1;
            }
        }

        return res;
    }

    public int[] numsGame_1(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        PriorityQueue<Integer> leftHeap = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>();
        long leftSum = 0, rightSum = 0;
        for (int i = 0; i < n; i++) {
            int b = nums[i] - i;
            if (i % 2 == 0) {
                if (!leftHeap.isEmpty() && b < leftHeap.peek()) {
                    leftSum -= leftHeap.peek() - b;
                    leftHeap.offer(b);
                    b = leftHeap.poll();
                }
                rightSum += b;
                rightHeap.offer(b);
                res[i] = (int) ((rightSum - rightHeap.peek() - leftSum) % MOD);
            } else {
                if (b > rightHeap.peek()) {
                    rightSum += b - rightHeap.peek();
                    rightHeap.offer(b);
                    b = rightHeap.poll();
                }
                leftSum += b;
                leftHeap.offer(b);
                res[i] = (int) ((rightSum - leftSum) % MOD);
            }
        }

        return res;
    }
}
