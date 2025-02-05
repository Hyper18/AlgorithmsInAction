package Array;

/**
 * @author Hyper
 * @date 2024/10/24
 * @file M3175_找到连续赢K场比赛的第一位玩家.java
 * <p>
 * 思路
 * 模拟
 * <p>
 * 特判了逆天测试用例，能一直赢的只能是最大值
 * skills = [16,4,7,17]，k = 562084119
 */
public class M3175_找到连续赢K场比赛的第一位玩家 {
    public int findWinningPlayer(int[] skills, int k) {
        int n = skills.length;
        int idx = 0;
        if (k > n - 1) {
            for (int i = 1; i < n; i++) {
                if (skills[i] > skills[idx]) {
                    idx = i;
                }
            }
            return idx;
        }
        int cnt = 0, i = 1;
        while (true) {
            if (cnt == k) {
                return idx;
            }
            if (skills[idx] > skills[i]) {
                cnt++;
            } else {
                cnt = 1;
                idx = i;
            }
            i = (i + 1 + n) % n;
        }
    }
}
