package String;

/**
 * @author Hyperspace
 * @date 2023/07/24
 * @file M771_宝石与石头.java
 */
public class M771_宝石与石头 {
    public int numJewelsInStones(String jewels, String stones) {
        int ans = 0;
        for (char c : stones.toCharArray()) {
            if (jewels.indexOf(c) >= 0) {
                ans++;
            }
        }

        return ans;
    }
}
