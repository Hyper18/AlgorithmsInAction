package BinarySearch;

/**
 * @author Hyperspace
 * @date 2024/11/04
 * @file M633_平方数之和.java
 * <p>
 * 思路
 * 二分，固定一端的a找b
 */
public class M633_平方数之和 {
    public boolean judgeSquareSum(int c) {
        int n = (int) Math.sqrt(c);
        for (int i = 0; i <= n; i++) {
            int low = 0, high = n, target = c - i * i;
            while (low <= high) {
                int mid = low + ((high - low) >> 1);
                int midVal = mid * mid;
                if (midVal == target) {
                    return true;
                } else if (midVal > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }

        return false;
    }
}
