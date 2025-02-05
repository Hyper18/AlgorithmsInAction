package Array;

/**
 * @author Hyper
 * @date 2024/05/18
 * @file M1953_你可以工作的最大周数.java
 * <p>
 * 思路
 * 模拟
 * 中文有点绕，实际限制条件是不能连续两周做同一个项目
 * 分类讨论：
 * 1) 不能完成全部项目
 * 转化为数组中除了最大的数以外的所有元素之和应不小于mx - 1
 * 为什么减1？因为第一次可以从最大元素开始
 * 此时最大可完成的项目数目为(sum - mx) * 2 + 1
 * 2) 能完成全部项目
 * 反之为数组的全元素求和
 * <p>
 * 注意10^9可能爆int
 */
public class M1953_你可以工作的最大周数 {
    public long numberOfWeeks(int[] milestones) {
        long mx = 0, sum = 0;
        for (int m : milestones) {
            sum += m;
            mx = Math.max(mx, m);
        }

        return sum - mx < mx - 1 ? (sum - mx) * 2 + 1 : sum;
    }
}
