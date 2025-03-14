package String;

/**
 * @author Hyperspace
 * @date 2025/03/14
 * @file M3340_检查平衡字符串.java
 * <p>
 * 思路
 * 模拟
 */
public class M3340_检查平衡字符串 {
    public boolean isBalanced(String num) {
        int diff = 0, cnt = 0;
        for (char c : num.toCharArray()) {
            int x = Integer.parseInt(String.valueOf(c));
            diff += cnt % 2 == 0 ? x % 10 : -x % 10;
            cnt++;
        }

        return diff == 0;
    }
}
