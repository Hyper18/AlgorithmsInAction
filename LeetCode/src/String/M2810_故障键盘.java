package String;

/**
 * @author Hyperspace
 * @date 2024/04/01
 * @file M2810_故障键盘.java
 * <p>
 * 思路
 * 模拟
 */
public class M2810_故障键盘 {
    public String finalString(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == 'i') {
                sb.reverse();
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
