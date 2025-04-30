package Array;

/**
 * @author Hyperspace
 * @date 2025/04/30
 * @file M1295_统计位数为偶数的数字.java
 */
public class M1295_统计位数为偶数的数字 {
    public int findNumbers(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            if (String.valueOf(num).length() % 2 == 0) {
                ans++;
            }
        }

        return ans;
    }
}
