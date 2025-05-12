package Array;

/**
 * @author Hyperspace
 * @date 2025/05/11
 * @file M1550_存在连续三个奇数的数组.java
 */
public class M1550_存在连续三个奇数的数组 {
    public boolean threeConsecutiveOdds(int[] arr) {
        int n = arr.length;
        for (int i = 2; i < n; i++) {
            if ((arr[i - 2] & 1) == 1 && (arr[i - 1] & 1) == 1 && (arr[i] & 1) == 1) {
                return true;
            }
        }

        return false;
    }
}
