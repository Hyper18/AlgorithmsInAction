package Y2017A;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Hyperspace
 * @date 2022/03/31
 * <p>
 * Review
 */
public class Q29数算式_2 {
    private static int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    private static final int n = nums.length;
    static int ans;

    public static void main(String[] args) {
        f(0);
        System.out.println(ans);
    }

    private static void f(int k) {
        if (k == n) {
            int left, right;
            for (int i = 1; i < 9; i++) {
                left = a2i(0, i);
                right = a2i(i, n);
                if (check(left * right)) {
                    ans++;
                }
            }
        }
        for (int i = k; i < n; i++) {
            swap(i, k);
            f(k + 1);
            swap(i, k);
        }
    }

    private static int a2i(int i, int j) {
        int num = 0;
        int p = 1;
        for (int k = j - 1; k >= i; k--) {
            num += nums[k] * p;
            p *= 10;
        }
        return num;
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

    private static void swap(int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
