package DP;

/**
 * @author Hyper
 * @date 2022/03/08
 * 滚动数组 + 状压DP
 */
public class Q1137_第N个泰波那契数 {
    public int tribonacci(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int head = 0;
        int pre = 1;
        int curr = 1;
        int tmp;
        for (int i = 3; i < n; i++) {
            tmp = head + pre + curr;
            head = pre;
            pre = curr;
            curr = tmp;
        }

        return curr;
    }
}
