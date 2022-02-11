package 二分查找;

/**
 * @author Hyperspace
 * @date 2022/02/11
 * 思路
 * 二分查找，左闭右开型
 * 从题意最后一个版本一定是坏版本，不计入考虑
 */
public class Q278_第一个错误的版本 {
    boolean isBadVersion(int version) {
        return true;
    }

    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;

        while (low < high) {
            // int mid = (low + high) / 2; 求均值超过2^32-1会溢出，导致超过时间限制
            // int mid = low + (high - low) / 2;
            int mid = low + ((high - low) >> 1);
            boolean res = isBadVersion(mid);
            if (res) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
