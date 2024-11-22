package Math;

/**
 * @author Hyperspace
 * @date 2024/11/22
 * @file M3233_统计不是特殊数字的数字数量.java
 * <p>
 * 思路
 * 1. 模拟
 * 2. 素数筛
 */
public class M3233_统计不是特殊数字的数字数量 {
    public int nonSpecialCount(int l, int r) {
        int ans = r - l + 1;
        for (int i = (int) Math.sqrt(l); i <= (int) Math.sqrt(r); i++) {
            if (i * i >= l && i * i <= r) {
                if (check(i)) {
                    ans--;
                }
            }
        }

        return ans;
    }

    private boolean check(int x) {
        if (x == 1) {
            return false;
        }
        for (int i = 2; i <= (int) Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }

        return true;
    }

    public int nonSpecialCount2(int l, int r) {
        int n = (int) Math.sqrt(r);
        boolean[] flag = new boolean[n + 1];
        int ans = r - l + 1;
        for (int i = 2; i <= n; i++) {
            if (!flag[i]) {
                if (i * i >= l && i * i <= r) {
                    ans--;
                }
                for (int j = i << 1; j <= n; j += i) {
                    flag[j] = true;
                }
            }
        }

        return ans;
    }
}
