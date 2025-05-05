package BackTracking;

/**
 * @author Hyperspace
 * @date 2025/05/05
 * @file Q2212_射箭比赛中的最大得分.java
 * <p>
 * 思路
 * 贪心+回溯
 */
public class Q2212_射箭比赛中的最大得分 {
    private int[] bobArrows, res, aliceArrows;
    private int numArrows, cur, sum;

    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int n = aliceArrows.length;
        this.numArrows = numArrows;
        this.aliceArrows = aliceArrows;
        res = new int[n];
        bobArrows = new int[n];
        backtrack(0, 0);
        int usedArrows = 0;
        for (int x : res) {
            usedArrows += x;
        }
        res[0] += numArrows - usedArrows;

        return res;
    }

    private void backtrack(int i, int cnt) {
        if (cnt > numArrows) {
            return;
        }
        if (i == aliceArrows.length) {
            if (cur > sum) {
                sum = cur;
                res = bobArrows.clone();
            }
            return;
        }
        backtrack(i + 1, cnt);
        bobArrows[i] = aliceArrows[i] + 1;
        cur += i;
        backtrack(i + 1, cnt + bobArrows[i]);
        cur -= i;
        bobArrows[i] = 0;
    }
}
