package String;

/**
 * @author Hyper
 * @date 2022/11/06
 * 思路
 * 模拟
 */
public class M1678_设计Goal解析器 {
    public String interpret(String cmd) {
        StringBuilder sb = new StringBuilder();
        int n = cmd.length();
        for (int i = 0; i < n; i++) {
            char c = cmd.charAt(i);
            if (c == 'G') {
                sb.append(c);
            }
            if (c == '(') {
                char ne = cmd.charAt(i + 1);
                if (ne == 'a') {
                    sb.append("al");
                    i += 2;
                } else if (ne == ')') {
                    sb.append('o');
                    i++;
                }
            }
        }

        return sb.toString();
    }
}
