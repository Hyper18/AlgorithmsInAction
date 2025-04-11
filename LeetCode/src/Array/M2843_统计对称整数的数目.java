package Array;

/**
 * @author Hyper
 * @date 2025/04/11
 * @file M2843_统计对称整数的数目.java
 * <p>
 * 思路
 * 模拟
 */
public class M2843_统计对称整数的数目 {
    public int countSymmetricIntegers(int low, int high) {
        int ans = 0;
        for (int i = low; i <= high; i++) {
            char[] cs = String.valueOf(i).toCharArray();
            int n = cs.length;
            if (n % 2 != 0) {
                continue;
            }
            int sum = 0;
            for (int j = 0; j < n / 2; j++) {
                sum += cs[j] - cs[n - 1 - j];
            }
            if (sum == 0) {
                ans++;
            }
        }

        return ans;
    }
}
