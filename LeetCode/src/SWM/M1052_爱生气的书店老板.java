package SWM;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Hyperspace
 * @date 2024/04/23
 * @file M1052_爱生气的书店老板.java
 * <p>
 * 思路
 * 模拟，SWM
 * <p>
 * 一开始卡在处理左侧窗口大小了
 */
public class M1052_爱生气的书店老板 {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        Queue<int[]> q = new ArrayDeque<>();
        int n = customers.length;
        int satisfied = 0, maxChanged = 0, t = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                satisfied += customers[i];
                continue;
            }
            while (!q.isEmpty() && i - q.peek()[0] + 1 > minutes) {
                t -= q.poll()[1];
            }
            q.offer(new int[]{i, customers[i]});
            t += customers[i];
            maxChanged = Math.max(maxChanged, t);
        }

        return satisfied + maxChanged;
    }
}
