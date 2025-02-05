package String;

/**
 * @author Hyper
 * @date 2023/03/06
 * @file M1653_使字符串平衡的最少删除次数.java
 * <p>
 * 思路
 * 模拟
 * 思路同官解
 * l表示左边界往左需要删除的b
 * r表示右边界往右需要删除的a
 */
public class M1653_使字符串平衡的最少删除次数 {
    public int minimumDeletions(String s) {
        int n = s.length();
        int r = 0, l = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                r++;
            }
        }
        int ans = r;
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                r--;
            } else {
                r++;
            }
            ans = Math.min(ans, r + r);
        }

        return ans;
    }
}
