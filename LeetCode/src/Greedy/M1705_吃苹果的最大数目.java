package Greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Hyperspace
 * @date 2024/12/24
 * @file M1705_吃苹果的最大数目.java
 * <p>
 * 思路
 * 平安夜就该吃苹果~
 * 小根堆，贪心
 * <p>
 * 注意：
 * (1) 不能直接全部放入优先队列后再贪心
 * 否则会出现在t=1时就吃掉t=2时加入的苹果的情况
 * 故在t<n时，需要先按时间依次插入
 * (2) 插入结束后，可优化
 * 没有了(1)的限制，可以按照普通贪心的做法做
 */
public class M1705_吃苹果的最大数目 {
    public int eatenApples(int[] apples, int[] days) {
        int n = apples.length;
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int ans = 0, t = 0;
        while (t < n || !q.isEmpty()) {
            if (t < n && apples[t] > 0) {
                q.offer(new int[]{apples[t], t + days[t]});
            }
            while (!q.isEmpty() && q.peek()[1] <= t) {
                q.poll();
            }
            if (!q.isEmpty()) {
                if (t < n) {
                    if (--q.peek()[0] == 0) {
                        q.poll();
                    }
                    ans++;
                } else {
                    int[] p = q.poll();
                    int cur = Math.min(p[0], p[1] - t);
                    ans += cur;
                    t += cur - 1;
                }
            }
            t++;
        }

        return ans;
    }
}
