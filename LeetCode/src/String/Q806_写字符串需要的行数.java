package String;

/**
 * @author Hyperspace
 * @date 2022/04/12
 * 模拟
 */
public class Q806_写字符串需要的行数 {
    public int[] numberOfLines(int[] widths, String s) {
        int lineWidth = 0;
        int ans = 0;
        for (char c : s.toCharArray()) {
            int width = widths[c - 'a'];
            if (lineWidth + width > 100) {
                lineWidth = width;
                ans++;
            } else {
                lineWidth += width;
            }
        }

        return new int[]{ans, lineWidth};
    }
}
