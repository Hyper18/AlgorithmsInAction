package Array;

/**
 * @author Hyperspace
 * @date 2023/10/26
 * @file M2520_统计能整除数字的位数.java
 */
public class M2520_统计能整除数字的位数 {
    public int countDigits(int num) {
        int ans = 0, t = num;
        while (t > 0) {
            if (num % (t % 10) == 0) {
                ans++;
            }
            t /= 10;
        }

        return ans;
    }
}
