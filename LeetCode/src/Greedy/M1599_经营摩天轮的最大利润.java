package Greedy;

/**
 * @author Hyper
 * @date 2023/03/05
 * @file M1599_经营摩天轮的最大利润.java
 * <p>
 * 思路
 * 贪心，每次尽量坐满
 * 分别用num和rem维护当前在摩天轮上和等待的人数
 * 记录盈利轮次的最大值
 * <p>
 * 测试案例给了启发，每次计算并比较总利润即可
 * 注意轮次从1开始
 */
public class M1599_经营摩天轮的最大利润 {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int n = customers.length;
        int ans = -1, sum = 0, num = 0, rem = 0;
        int i = 1;
        while (i <= n || rem > 0) {
            if (i <= n) {
                rem += customers[i - 1];
            }
            if (rem > 4) {
                num += 4;
                rem -= 4;
            } else {
                num += rem;
                rem = 0;
            }
            int cur = num * boardingCost - i * runningCost;
            if (sum < cur) {
                sum = cur;
                ans = i;
            }
            i++;
        }

        return ans;
    }
}
