package Array;

/**
 * @author Hyper
 * @date 2024/07/25
 * @file M2844_生成特殊数字的最少操作.java
 * <p>
 * 思路
 * 模拟
 * 1. 00 50
 * 2. 25 75
 */
public class M2844_生成特殊数字的最少操作 {
    public int minimumOperations(String num) {
        int n = num.length();
        boolean isZero = false, isFive = false;
        for (int i = n - 1; i >= 0; i--) {
            char c = num.charAt(i);
            if (isZero && (c == '0' || c == '5') ||
                    isFive && (c == '2' || c == '7')) {
                return n - i - 2;
            }
            if (c == '0') {
                isZero = true;
            } else if (c == '5') {
                isFive = true;
            }
        }

        return isZero ? n - 1 : n;
    }
}
