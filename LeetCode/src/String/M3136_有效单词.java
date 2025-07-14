package String;

/**
 * @author Hyperspace
 * @date 2025/07/15
 * @file M3136_有效单词.java
 * <p>
 * 思路
 * 模拟
 */
public class M3136_有效单词 {
    public boolean isValid(String word) {
        if (word.length() < 3) {
            return false;
        }
        char[] s = word.toCharArray();
        boolean f1 = false, f2 = false;
        for (char c : s) {
            c = Character.toLowerCase(c);
            if (!Character.isLetter(c) && !Character.isDigit(c)) {
                return false;
            }
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                f1 = true;
            } else if (Character.isLetter(c)) {
                f2 = true;
            }
        }

        return f1 && f2;
    }
}
