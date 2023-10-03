package BinarySearch;

/**
 * @author Hyperspace
 * @date 2023/09/07
 * @file M2594_修车的最少时间.java
 * <p>
 * 思路
 * 二分
 * rank越靠前修的越快
 * <p>
 * 注意爆int
 */
public class M2594_修车的最少时间 {
    final long N = (long) 1e14 + 10;

    public long repairCars(int[] ranks, int cars) {
        long low = 0, high = N - 1;
        while (low < high) {
            long mid = low + ((high - low) >> 1);
            if (check(ranks, cars, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    boolean check(int[] ranks, int cars, long mid) {
        long ans = 0;
        for (int r : ranks) {
            ans += Math.sqrt(mid / r);
        }

        return ans >= cars;
    }
}
