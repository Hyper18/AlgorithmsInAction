package Array;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Hyper
 * @date 2023/10/28
 * @file M558_从数量最多的堆取走礼物.java
 * <p>
 * 思路
 * 模拟，大根堆
 */
public class M558_从数量最多的堆取走礼物 {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        for (int gift : gifts) {
            q.offer(gift);
        }
        while (k-- > 0) {
            q.offer((int) Math.sqrt(q.poll()));
        }
        long ans = 0;
        while (!q.isEmpty()) {
            ans += q.poll();
        }

        return ans;
    }
}
