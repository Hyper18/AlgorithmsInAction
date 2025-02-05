package Array;

/**
 * @author Hyper
 * @date 2024/09/29
 * @file M2073_买票需要的时间.java
 * <p>
 * 思路
 * 模拟
 * 1. 两遍遍历，先收集次数再统计
 * 2. 直接收集数目
 * 3. 优化
 */
public class M2073_买票需要的时间 {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets.length, len = tickets[k] + 1;
        int[] count = new int[len];
        for (int i = 0, s = tickets[k]; i < n; i++) {
            int t = tickets[i];
            if (i > k && t >= s) {
                count[s - 1]++;
            } else {
                count[Math.min(t, s)]++;
            }
        }
        int ans = 0;
        for (int i = 1; i <= tickets[k]; i++) {
            ans += count[i] * i;
        }

        return ans;
    }

    public int timeRequiredToBuy2(int[] tickets, int k) {
        int n = tickets.length;
        int ans = 0;
        for (int i = 0, s = tickets[k]; i < n; i++) {
            int t = tickets[i];
            if (i > k) {
                ans += Math.min(t, s - 1);
            } else {
                ans += Math.min(t, s);
            }
        }

        return ans;
    }

    public int timeRequiredToBuy3(int[] tickets, int k) {
        int n = tickets.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(tickets[i], i > k ? tickets[k] - 1 : tickets[k]);
        }

        return ans;
    }
}
