package Greedy;

/**
 * @author Hyperspace
 * @date 2025/05/03
 * @file M1007_行相等的最少多米诺旋转.java
 * <p>
 * 思路
 * 贪心
 * 遍历，从第一个数开始判断
 * 跟多米诺没有太多关系
 * 本质还是两个数组操作
 */
public class M1007_行相等的最少多米诺旋转 {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int ans = Math.min(check(tops, bottoms, tops[0]), check(tops, bottoms, bottoms[0]));
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int check(int[] tops, int[] bottoms, int target) {
        int n = tops.length;
        int cntT = 0, cntB = 0;
        for (int i = 0; i < n; i++) {
            int x = tops[i], y = bottoms[i];
            if (x != target && y != target) {
                return Integer.MAX_VALUE;
            }
            if (x != target) {
                cntT++;
            } else if (y != target) {
                cntB++;
            }
        }

        return Math.min(cntT, cntB);
    }
}
