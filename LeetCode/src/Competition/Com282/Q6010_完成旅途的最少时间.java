package Competition.Com282;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2022/02/27
 * <p>
 * 思路
 * 1. 暴力（上溢）
 * 2. 二分法
 * 注意long溢出的情况
 */
public class Q6010_完成旅途的最少时间 {
    public long minimumTime(int[] time, int totalTrips) {
        int n = time.length;
        int cnt = 0;
        int t = Arrays.stream(time).min().getAsInt() - 1;
        while (cnt < totalTrips) {
            t++;
            for (int i = 0; i < n; i++) {
                if (t % time[i] == 0) {
                    cnt++;
                }
            }
        }

        return t;
    }

    public long minimumTime2(int[] time, int totalTrips) {
        int len = time.length;
        long low = 1;
        long high = totalTrips * 10000000L;
        while (low < high) {
            long mid = (low + high) / 2;
            long total = 0;
            for (int i = 0; i < len; i++) {
                total += mid / time[i];
            }
            if (total < totalTrips) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
