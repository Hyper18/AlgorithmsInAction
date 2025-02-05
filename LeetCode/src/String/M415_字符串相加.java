package String;

/**
 * @author Hyper
 * @date 2023/07/17
 * @file M415_字符串相加.java
 * <p>
 * 思路
 * 模拟两数相加
 */
public class M415_字符串相加 {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int m = num1.length(), n = num2.length();
        int i = m - 1, j = n - 1, t = 0;
        while (i >= 0 || j >= 0 || t == 1) {
            int a = i >= 0 ? num1.charAt(i) - '0' : 0;
            int b = j >= 0 ? num2.charAt(j) - '0' : 0;
            t += a + b;
            sb.append(t % 10);
            t /= 10;
            i--;
            j--;
        }

        return sb.reverse().toString();
    }
}
