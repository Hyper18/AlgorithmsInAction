package Greedy;

/**
 * @author Hyperspace
 * @date 2025/02/20
 * @file Q134_加油站.java
 * <p>
 * 思路
 * 模拟
 */
public class Q134_加油站 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        while (i < n) {
            int t = gas[i], cnt = 0;
            while (cnt < n) {
                int j = (i + cnt + n) % n;
                t -= cost[j];
                if (t < 0) {
                    break;
                }
                t += gas[(j + 1) % n];
                cnt++;
            }
            if (cnt == n) {
                return i;
            } else {
                i += cnt + 1;
            }
        }

        return -1;
    }
}
