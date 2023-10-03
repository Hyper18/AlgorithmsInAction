package Array;

/**
 * @author Hyperspace
 * @date 2023/09/02
 * @file M2511_最多可以摧毁的敌人城堡数目.java
 * <p>
 * 思路
 * 双指针模拟
 * 由于题干限定军队经过的位置只有敌人的城堡
 * 即为求-1与1之间的最大连续0数目
 */
public class M2511_最多可以摧毁的敌人城堡数目 {
    public int captureForts(int[] forts) {
        int n = forts.length;
        int ans = 0;
        for (int i = -1, j = 0; j < n; j++) {
            if (forts[j] == 0) {
                continue;
            }
            if (i != -1 && forts[j] != forts[i]) {
                ans = Math.max(ans, j - i - 1);
            }
            i = j;
        }

        return ans;
    }
}
