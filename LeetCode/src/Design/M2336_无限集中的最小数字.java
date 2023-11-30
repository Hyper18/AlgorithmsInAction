package Design;

import java.util.PriorityQueue;

/**
 * @author Hyperspace
 * @date 2023/11/30
 * @file M2336_无限集中的最小数字.java
 * <p>
 * 思路
 * 小根堆
 */
public class M2336_无限集中的最小数字 {
    class SmallestInfiniteSet {
        final int N = 1010;
        PriorityQueue<Integer> q;

        public SmallestInfiniteSet() {
            q = new PriorityQueue<>();
            for (int i = 1; i <= N; i++) {
                q.offer(i);
            }
        }

        public int popSmallest() {
            return q.poll();
        }

        public void addBack(int num) {
            if (!q.contains(num)) {
                q.offer(num);
            }
        }
    }

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
}
