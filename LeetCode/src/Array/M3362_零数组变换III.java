package Array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Hyperspace
 * @date 2025/05/22
 * @file M3362_零数组变换III.java
 * <p>
 * 思路
 * 差分+反悔贪心
 * 在遍历的过程中维护一个最大堆
 */
public class M3362_零数组变换III {
    public int maxRemoval(int[] nums, int[][] queries) {
        Arrays.sort(queries, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        int n = nums.length;
        int[] diff = new int[n + 1];
        for (int i = 0, j = 0, sum = 0; i < n; i++) {
            sum += diff[i];
            while (j < queries.length && queries[j][0] <= i) {
                q.add(queries[j][1]);
                j++;
            }
            while (sum < nums[i] && !q.isEmpty() && q.peek() >= i) {
                sum++;
                diff[q.poll() + 1]--;
            }
            if (sum < nums[i]) {
                return -1;
            }
        }

        return q.size();
    }
}
