package Array;

/**
 * @author Hyperspace
 * @date 2025/01/11
 * @file M3270_求出数字答案.java
 */
public class M3270_求出数字答案 {
    public int generateKey(int num1, int num2, int num3) {
        int ans = 0, base = 1;
        while (num1 > 0 && num2 > 0 && num3 > 0) {
            ans += Math.min(num1 % 10, Math.min(num2 % 10, num3 % 10)) * base;
            base *= 10;
            num1 /= 10;
            num2 /= 10;
            num3 /= 10;
        }

        return ans;
    }
}
