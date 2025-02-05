package BinarySearch;

/**
 * @author Hyper
 * @date 2022/10/10
 * <p>
 * 思路
 * 1. 数学做法，先转化为以e为底数再套用Math工具类解决
 * 2. 二分
 */
public class Q69_x的平方根 {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int ans = (int) Math.exp(0.5 * Math.log(x));
        return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }

    public int mySqrt2(int x) {
        int low = 0, high = x;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // 需要注意溢出的情况
            if ((long) mid * mid <= x) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}
