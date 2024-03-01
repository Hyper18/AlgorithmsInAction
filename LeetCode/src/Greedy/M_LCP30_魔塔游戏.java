package Greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Hyperspace
 * @date 2024/02/06
 * @file M_LCP30_魔塔游戏.java
 * <p>
 * 思路
 * 优先队列，贪心
 * <p>
 * 注意不要爆int
 */
public class M_LCP30_魔塔游戏 {
    public int magicTower(int[] nums) {
        if (Arrays.stream(nums).sum() < 0) {
            return -1;
        }
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int ans = 0;
        long sum = 0;
        for (int num : nums) {
            if (num < 0) {
                q.offer(num);
            }
            sum += num;
            if (sum < 0) {
                sum -= q.poll();
                ans++;
            }
        }

        return ans;
    }
}
