package SWM;

/**
 * @author Hyperspace
 * @date 2024/09/11
 * @file M2555_两个线段获得的最多奖品.java
 * <p>
 * 思路
 * SWM+双指针+前缀和
 * l只在右侧-左侧＞k时右移
 * pre[i]: 前缀和收集走到第i个元素时的最大长度
 * ans: pre[i]+第二段的最大长度
 */
public class M2555_两个线段获得的最多奖品 {
    public int maximizeWin(int[] prizePositions, int k) {
        int n = prizePositions.length;
        int ans = 0;
        int[] pre = new int[n + 1];
        for (int l = 0, r = 0; r < n; r++) {
            while (prizePositions[r] - prizePositions[l] > k) {
                l++;
            }
            ans = Math.max(ans, pre[l] + r - l + 1);
            pre[r + 1] = Math.max(pre[r], r - l + 1);
        }

        return ans;
    }
}
