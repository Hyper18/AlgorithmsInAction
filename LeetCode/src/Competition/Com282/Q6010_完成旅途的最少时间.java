package Competition.Com282;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2022/02/27
 * <p>
 * 思路
 * 1. 暴力（上溢）
 * 2. 二分
 * 注意long溢出的情况
 * 数据范围最大可能值是max(time)*totalTrips，最多可能达到1e^14
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

    public long minimumTime3_0(int[] time, int totalTrips) {
        long low = 1, high = totalTrips * 10000000L;
        while (low <= high) {
            long mid = low + ((high - low) >> 1);
            if (check(time, mid, totalTrips)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    private boolean check(int[] time, long mid, int totalTrips) {
        long ans = 0;
        for (int t : time) {
            ans += mid / t;
            if (ans >= totalTrips) {
                return true;
            }
        }

        return false;
    }

    public long minimumTime3_1(int[] time, int totalTrips) {
        int n = time.length;
        int mn = Integer.MAX_VALUE, mx = 0;
        for (int t : time) {
            mn = Math.min(mn, t);
            mx = Math.max(mx, t);
        }
        int avg = (totalTrips - 1) / n + 1;
        long low = (long) mn * avg - 1, high = Math.min((long) mx * avg, (long) mn * totalTrips);
        while (low <= high) {
            long mid = low + ((high - low) >> 1);
            if (check(time, mid, totalTrips)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    private boolean check2(int[] time, long mid, int totalTrips) {
        long ans = 0;
        for (int t : time) {
            ans += mid / t;
            if (ans >= totalTrips) {
                return false;
            }
        }

        return true;
    }
}
