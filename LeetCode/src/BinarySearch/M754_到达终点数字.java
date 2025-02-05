package BinarySearch;

/**
 * @author Hyper
 * @date 2022/11/04
 * <p>
 * 思路@Tizzi
 * 二分
 */
public class M754_到达终点数字 {
    public int reachNumber(int target) {
        // target初值的正负不影响结果
        if (target < 0) {
            target = -target;
        }
        int low = 1, high = target;
        while (low < high) {
            int mid = (low + high) / 2;
            if ((1 + (long) mid) * mid / 2 < target) {
                // 寻找第一个n 使 (1+n) * n / 2 >= target
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        int sum = (1 + high) * high / 2;

        // （1）若n为偶数，n+1为奇数，只用前进一步，sum-target变为偶数
        // （2）若n为奇数，前进两步后，sum-target变为偶数
        return (sum - target) % 2 == 0 ? high : high + 1 + high % 2;
    }
}
