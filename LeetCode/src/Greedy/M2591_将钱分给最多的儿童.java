package Greedy;

/**
 * @author Hyperspace
 * @date 2023/09/22
 * @file M2591_将钱分给最多的儿童.java
 * <p>
 * 思路
 * 贪心
 * 分类讨论：
 * 1. 当钱不够让每个儿童获得1美元时
 * 返回-1
 * 2. 当钱超过让每个儿童获得8美元时
 * 返回儿童的总人数-1
 * 3. 对于其他情况，考虑不让最后一个儿童恰好获得4美元
 * <p>
 * 注意考虑第二类情况，因为此时采用贪心的做法，
 * 则最后一个儿童获得的钱数一定大于8美元
 */
public class M2591_将钱分给最多的儿童 {
    public int distMoney(int money, int children) {
        if (money < children) {
            return -1;
        }
        if (money > children * 8) {
            return children - 1;
        }
        money -= children;
        int ans = money / 7, left = money % 7;
        if (ans == children - 1 && left == 3) {
            return ans - 1;
        }

        return ans;
    }
}
