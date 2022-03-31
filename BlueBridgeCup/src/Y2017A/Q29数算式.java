package Y2017A;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Hyperspace
 * @date 2022/03/30
 * <p>
 * 观察如下的算式：
 * <p>
 * 9213 x 85674 = 789314562
 * <p>
 * 左边的乘数和被乘数正好用到了1~9的所有数字，每个1次。
 * 而乘积恰好也是用到了1~9的所有数字，并且每个1次。
 * <p>
 * 请你借助计算机的强大计算能力，找出满足如上要求的9数算式一共有多少个？
 * <p>
 * 注意：
 * 1. 总数目包含题目给出的那个示例。
 * 2. 乘数和被乘数交换后作为同一方案来看待。
 * <p>
 * 注意不要混淆变量名!!
 */
public class Q29数算式 {
    private static int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    private static final int n = nums.length;
    static int ans;

    public static void main(String[] args) {
        f(0);
        System.out.println(ans);
    }

    private static void f(int k) {
        if (k == n) {
            for (int i = 1; i < n; i++) {
                int left = a2i(0, i);
                int right = a2i(i, n);
                int mul = left * right;
                if (check(mul)) {
                    ans++;
                }
            }
            return;
        }
        for (int i = k; i < n; i++) {
            swap(k, i);
            f(k + 1);
            swap(k, i);
        }
    }

    private static int a2i(int i, int j) {
        int num = 0;
        int base = 1;
        for (int k = j - 1; k >= i; k--) {
            num += nums[k] * base;
            base *= 10;
        }
        return num;
    }

    private static void swap(int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private static boolean check(int x) {
        String s = "" + x;
        if (s.length() != n || s.contains("0")) {
            return false;
        }
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!set.add(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 错误范例
     *
     * @param n
     * @return
     */
    private static boolean check2(int n) {
        String s = "" + n;
        // 形参中的n代替了全局变量的n生效，导致输出错误
        if (s.length() != n || s.contains("0")) {
            return false;
        }
        return true;
    }
}
