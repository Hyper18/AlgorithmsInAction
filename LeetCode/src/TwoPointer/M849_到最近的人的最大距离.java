package TwoPointer;

/**
 * @author Hyper
 * @date 2023/08/22
 * @file M849_到最近的人的最大距离.java
 * <p>
 * 思路
 * 模拟，分别处理：
 * 1) 第一个有人座位左侧长度
 * 2) 两人之间长度，偶数个空取较长一侧
 * 3) 最后一个有人座位右侧长度
 */
public class M849_到最近的人的最大距离 {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int ans = 0, i = 0, j = 0;
        while (seats[j] != 1) {
            j++;
        }
        if (i < j) {
            ans = j - i;
            i = j;
        }
        while (j < n - 1) {
            if (seats[++j] == 1) {
                int cur = (j - i) >> 1;
                if (cur > ans) {
                    ans = cur;
                }
                i = j;
            }
        }

        return Math.max(j - i, ans);
    }
}
