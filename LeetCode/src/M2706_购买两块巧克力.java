/**
 * @author Hyper
 * @date 2023/12/29
 * @file M2706_购买两块巧克力.java
 * <p>
 * 思路
 * 模拟
 */
public class M2706_购买两块巧克力 {
    public int buyChoco(int[] prices, int money) {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < first) {
                second = first;
                first = price;
            } else if (price < second) {
                second = price;
            }
        }

        return first + second > money ? money : money - first - second;
    }
}
