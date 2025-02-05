package String;

/**
 * @author Hyper
 * @date 2024/06/29
 * @file M2710_移除字符串中的尾随零.java
 */
public class M2710_移除字符串中的尾随零 {
    public String removeTrailingZeros(String num) {
        int n = num.length();
        int i = n - 1;
        for (; i > 0; i--) {
            if (num.charAt(i) != '0') {
                break;
            }
        }

        return num.substring(0, i + 1);
    }
}
