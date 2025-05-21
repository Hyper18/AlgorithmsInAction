package Array;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Hyperspace
 * @date 2025/05/21
 * @file Q_面试题17_14_最小K个数.java
 * <p>
 * 思路
 * topK问题
 * 建大根堆，每次选取值与root比较
 * 若小于，则将这个新值加入堆，替换root，并重新进行堆排序
 * 时间复杂度 -- O(nlog_k)
 * 空间复杂度 -- O(k)
 */
public class Q_面试题17_14_最小K个数 {
    public int[] smallestK(int[] arr, int k) {
        if (arr.length == 0 || k == 0) {
            return new int[]{};
        }
        int n = arr.length;
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < k; i++) {
            q.offer(arr[i]);
        }
        for (int i = k; i < n; i++) {
            if (q.peek() > arr[i]) {
                q.poll();
                q.offer(arr[i]);
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = q.poll();
        }

        return res;
    }
}
