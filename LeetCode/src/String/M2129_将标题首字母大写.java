package String;

/**
 * @author Hyperspace
 * @date 2024/03/11
 * @file M2129_将标题首字母大写.java
 * <p>
 * 思路
 * 模拟
 */
public class M2129_将标题首字母大写 {
    public String capitalizeTitle(String title) {
        StringBuilder sb = new StringBuilder();
        String[] s = title.split(" ");
        int n = s.length;
        for (int i = 0; i < n; i++) {
            String ss = s[i];
            if (ss.length() <= 2) {
                sb.append(ss.toLowerCase());
            } else {
                sb.append(ss.substring(0, 1).toUpperCase())
                        .append(ss.substring(1).toLowerCase());
            }
            if (i != n - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}
