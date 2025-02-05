package Greedy;

/**
 * @author Hyper
 * @date 2024/06/06
 * @file M2938_区分黑球与白球.java
 * <p>
 * 思路
 * 贪心
 */
public class M2938_区分黑球与白球 {
    public long minimumSteps(String s) {
        long ans = 0;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                sum++;
            } else {
                ans += sum;
            }
        }
        return ans;
    }
}
