package Array;

/**
 * @author Hyperspace
 * @date 2025/05/04
 * @file M1128_等价多米诺骨牌对的数量.java
 * <p>
 * 思路
 * 模拟
 * 观察题干可以发现给定的数都在0~9之间
 * 可以将每个数对转化成唯一表示并计数
 */
public class M1128_等价多米诺骨牌对的数量 {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] cnt = new int[100];
        int ans = 0;
        for (int[] d : dominoes) {
            int x = d[0] < d[1] ? d[0] * 10 + d[1] : d[1] * 10 + d[0];
            ans += cnt[x]++;
        }

        return ans;
    }
}
