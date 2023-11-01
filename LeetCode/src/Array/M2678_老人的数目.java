package Array;

/**
 * @author Hyperspace
 * @date 2023/10/23
 * @file M2678_老人的数目.java
 * <p>
 * 思路
 * 模拟
 */
public class M2678_老人的数目 {
    public int countSeniors(String[] details) {
        int ans = 0;
        for (String d : details) {
            if ((d.charAt(11) - '0') * 10 + d.charAt(12) - '0' > 60) {
                ans++;
            }
        }

        return ans;
    }

    public int countSeniors2(String[] details) {
        int ans = 0;
        for (String d : details) {
            if (Integer.parseInt(d.substring(11, 13)) > 60) {
                ans++;
            }
        }

        return ans;
    }
}
