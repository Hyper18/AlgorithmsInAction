package Array;

/**
 * @author Hyperspace
 * @date 2023/10/25
 * @file M2698_求一个整数的惩罚数.java
 * <p>
 * 思路
 * 递归
 * 对于1~n的每一个数，依次比较
 * i*i的每一位加和是否等于i
 * 比如一开始是n=81，r=9
 * n的最低位1，r=9，i剩余9-1=8
 * 递归比较8，r=8，此时i还剩余8-8=0，返回true
 */
public class M2698_求一个整数的惩罚数 {
    public int punishmentNumber(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (check(i * i, i)) {
                ans += i * i;
            }
        }

        return ans;
    }

    private boolean check(int n, int r) {
        if (n < r) {
            return false;
        }
        if (n == r) {
            return true;
        }
        for (int base = 10; base < n; base *= 10) {
            if (check(n / base, r - n % base)) {
                return true;
            }
        }

        return false;
    }
}
