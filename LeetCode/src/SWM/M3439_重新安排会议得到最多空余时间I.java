package SWM;

/**
 * @author Hyperspace
 * @date 2025/07/09
 * @file M3439_重新安排会议得到最多空余时间I.java
 * <p>
 * 思路@灵茶山艾府
 * SWM+前缀和 -- O(n)
 * 一开始写的SWM+双端队列，没抓到重点
 * 其实可以用前缀和保存所有空闲的时间段长度
 * 定长滑窗，取最大
 */
public class M3439_重新安排会议得到最多空余时间I {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] free = new int[n + 1];
        free[0] = startTime[0];
        for (int i = 1; i < n; i++) {
            free[i] = startTime[i] - endTime[i - 1];
        }
        free[n] = eventTime - endTime[n - 1];
        int ans = 0, mx = 0;
        for (int i = 0; i <= n; i++) {
            mx += free[i];
            if (i < k) {
                continue;
            }
            ans = Math.max(ans, mx);
            mx -= free[i - k];
        }

        return ans;
    }
}
