package Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Hyper
 * @date 2023/07/25
 * @file M2208_将数组和减半的最少操作次数.java
 * <p>
 * 思路
 * 大根堆，贪心
 * 注意sum不要爆int
 */
public class M2208_将数组和减半的最少操作次数 {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> q = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            q.offer((double) num);
        }
        int ans = 0;
        double sum = Arrays.stream(nums).asLongStream().sum(), cur = sum;
        while (cur > sum / 2) {
            double num = q.poll() / 2;
            q.offer(num);
            cur -= num;
            ans++;
        }

        return ans;
    }
}
