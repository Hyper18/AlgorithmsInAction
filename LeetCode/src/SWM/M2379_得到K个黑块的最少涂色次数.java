package SWM;

/**
 * @author Hyperspace
 * @date 2023/03/09
 * @file M2379_得到K个黑块的最少涂色次数.java
 * <p>
 * 思路 SWM
 * 维护窗口内白色块的数目
 * 先统计初始窗口，后左右侧指针一并移动
 */
public class M2379_得到K个黑块的最少涂色次数 {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int cnt = 0, l = 0, r = 0;
        while (r < k) {
            cnt += blocks.charAt(r++) == 'W' ? 1 : 0;
        }
        int ans = cnt;
        while (r < n) {
            cnt += blocks.charAt(r++) == 'W' ? 1 : 0;
            cnt -= blocks.charAt(l++) == 'W' ? 1 : 0;
            ans = Math.min(ans, cnt);
        }

        return ans;
    }
}
