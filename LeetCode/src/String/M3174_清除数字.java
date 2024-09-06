package String;

/**
 * @author Hyperspace
 * @date 2024/09/05
 * @file M3174_清除数字.java
 */
public class M3174_清除数字 {
    public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (sb.length() > 0 && Character.isDigit(c)) {
                sb.deleteCharAt(sb.length() - 1);
                continue;
            }
            sb.append(c);
        }

        return sb.toString();
    }
}
